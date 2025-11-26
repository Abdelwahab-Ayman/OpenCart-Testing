# OpenCart Automation Project Schedule

## 🗓️ Project Assignments
## 👤 @Alaa  
**Task:** Login and Logout Automation

**Details:**
- Setup Selenium WebDriver with Java
- Configure TestNG framework
- Create base test class
- Implement login scenarios:
  - Valid credentials
  - Invalid credentials
  - Empty fields validation
- Implement logout functionality
- Page Object Model structure
**Tech Stack:** Selenium Java, TestNG, Page Factory

### **👤 @moemen **
**Task:** Search Functionality Automation

**Details:**
- Search product by name
- Search product by category
- Empty search validation
- Search with special characters
- Search results verification
- Advanced search filters
**Tech Stack:** Selenium Java, TestNG, Data Providers

## 👤 @Momen
**Task:** Register

**Details:**
- User dashboard navigation
- Menu navigation automation
- Breadcrumb verification
- Page loading wait strategies
- Responsive design testing
- Cross-browser compatibility
**Tech Stack:** Selenium ,

### **👤 @Ahmed Dandrawy **
**Task:** User Registration Automation

**Details:**
- New user registration
- Mandatory field validation
- Email format validation
- Password strength validation
- Duplicate email registration
- Registration success flow
- GDPR/compliance checkboxes
**Tech Stack:** Selenium Java, TestNG, Data-Driven Testing

## 👤 @abdelwahab
**Task:** Wishlist

**Details:**
**Wishlist:**
- Add products to wishlist
- Wishlist page management
- Move wishlist to cart
- Remove from wishlist
- Wishlist persistence
**Tech Stack:** Selenium Actions, TestNG Assertions
### **Project Structure**
```
src/
├── main/java/com/opencart/
│   ├── pages/
│   ├── tests/
│   ├── utilities/
│   └── listeners/
└── test/resources/
    ├── testdata/
    ├── config.properties
    └── testng.xml
```

### **Key Automation Components**
1. **Page Object Model** - Each page as separate class
2. **TestNG** - For test execution and reporting
3. **Data-Driven Testing** - Excel/JSON test data
4. **Maven** - Dependency management
5. **Extent Reports** - Detailed test reporting

### **Weekly Deliverables**
- **Week 1:** Basic framework + Login/Logout tests
- **Week 2:** Search + Registration functionality
- **Week 3:** Complete e-commerce workflow tests

Would you like me to elaborate on any specific part of this automation schedule or add more technical details about the implementation?
