package customer.service.com.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import customer.service.com.Dao.IProductDao;
import customer.service.com.Entity.ExcelEntity;
import customer.service.com.Entity.Product;
import customer.service.com.Service.IProductService;
import customer.service.com.ServiceConstant.ServiceConstants;

@RestController
@RequestMapping("api/product")
public class ProductController {
	private final Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	IProductService productService;

	@Autowired
	IProductDao productDao;


// Get product list by supplier name
	@GetMapping("getallproduct/{supplier}")
	public ResponseEntity<List<Product>> getAllProductDetailsBySupplierName(@PathVariable("supplier") String supplier) {
		List<Product> productList = productService.getAllProductDetailsBySupplierName(supplier);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	// This api is Use for get only that product list not expaired and

	@GetMapping("getproductlist/{supplier}")
	public ResponseEntity<List<Product>> getProductListBySupplier(@PathVariable("supplier") String supplier) {
		List<Product> productList = productService.getAllProductDetailsBySupplierName(supplier);
		ArrayList<Product> newProductList = new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			LocalDate expiryDate = productList.get(i).getExpiryDate();
			Date todayDate = new Date();
			LocalDate convertTodayDate = todayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (expiryDate.compareTo(convertTodayDate) > 0) {
				newProductList.add(productList.get(i));
			}

		}
		return new ResponseEntity<List<Product>>(newProductList, HttpStatus.OK);
	}

	@GetMapping("search/index")
	public ResponseEntity<String> indexAll() {
		productDao.indexProduct();
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

//This api is used to search data by product name
	@GetMapping("search/{keyword}")
	public ResponseEntity<List<Product>> searchAllBrandBykeyword(@PathVariable("keyword") String keyword) {
		List<Product> result = new ArrayList<Product>();
		result = productDao.searchProduct(keyword);
		return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
	}

// This api is use for upload CSV flie
	@GetMapping("upload/csv")
	public ResponseEntity<Map<String, String>> getExcelFile1() {
		Map<String, String> response = new HashMap<String, String>();
		File data = new File("interview.xlsx");
		Product product = null;
		boolean productCreate = false;
		try {
			FileInputStream file = new FileInputStream(data);
			Workbook workbook = new XSSFWorkbook(file);
			Iterator<Sheet> sheets = workbook.sheetIterator();

			while (sheets.hasNext()) {
				Sheet sheet = sheets.next();
				// This loop is use for reading Row in a sheet
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					product = new Product();

					// This loop is use for reading column in each row
					for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
						String cellHeading = sheet.getRow(0).getCell(j).toString();
						String cellData = null;
						if (sheet.getRow(i).getCell(j) != null) {
							cellData = sheet.getRow(i).getCell(j).toString();
							Cell cell = sheet.getRow(i).getCell(j);
							switch (cellHeading) {
							case "code":
								if (null != cellData) {
									product.setCode(cellData);
								}
								break;
							case "name":
								if (null != cellData) {
									product.setName(cellData);
								}
								break;
							case "batch":
								if (null != cellData) {
									product.setBatch(cellData);
								}
								break;
							case "stock":
								if (null != cellData) {
									int cellValue = (int) cell.getNumericCellValue();
									product.setStock(cellValue);
								}
								break;
							case "deal":
								if (null != cellData) {
									int cellValue = (int) cell.getNumericCellValue();
									product.setDeal(cellValue);
								}
								break;
							case "free":
								if (null != cellData) {
									int cellValue = (int) cell.getNumericCellValue();
									product.setFree(cellValue);
								}
								break;
							case "mrp":
								if (null != cellData) {
									int cellValue = (int) cell.getNumericCellValue();
									product.setMrp(cellValue);
								}
								break;
							case "rate":
								if (null != cellData) {
									int cellValue = (int) cell.getNumericCellValue();
									product.setRate(cellValue);
								}
								break;
							case "exp":
								if (null != cellData) {
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
									LocalDate expDate = null;
									try {
										expDate = LocalDate.parse(cellData, formatter);
										product.setExpiryDate(expDate);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								break;
							case "company":
								if (null != cellData) {
									product.setCompany(cellData);
								}
								break;
							case "supplier":
								if (null != cellData) {
									product.setSupplier(cellData);
									productCreate = productService.createProduct(product);
								}
								break;
							default:
								String s = "Last data";

							}

						}

					}
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (productCreate) {
			response.put("status", Boolean.TRUE.toString());
			response.put("Description", "Product created");
		} else {
			response.put("status", Boolean.FALSE.toString());
			response.put("Description", "Product is not create");
		}
		return ResponseEntity.ok().body(response);
	}

}
