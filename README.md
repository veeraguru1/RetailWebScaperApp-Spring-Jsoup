# RetailWebScaperApp

## 1. Clone the project

Use following commands to clone the project

```
git clone https://github.com/veeraguru1/RetailWebScaperApp-Spring-Jsoup.git
```

Go to your project directory. For example:

```
cd RetailWebScaperApp-Spring-Jsoup
```
 
## 2. Build the project

Use following command to build the project

```
mvn clean install
```
## 2. Run Tests  or console .

console:

Use following command to run the tests

```
mvn test

```
intelligi:

```
1) Run All test case from com.veera package
2) Right click the open com.veera and run 'Tests in 'com.veera''
```

## 3. Run the application

console:

Use following command to run the project using command line:
```
java -jar target/RetailWebScrapApplication-0.0.1-SNAPSHOT.jar
```

intelligi:

```
1) import RetailWebScaperApp-Spring-Jsoup folder into intelliJ
2) Run RetailWebScrapApplication class from intelliJ - com.veera/RetailWebScrapApplication main class
```

Result:

```
Below are the warning due to Java 9 and Spring library.

WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.springframework.cglib.core.ReflectUtils$1 (file:/Users/veeraguru.s/.m2/repository/org/springframework/spring-core/4.3.7.RELEASE/spring-core-4.3.7.RELEASE.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of org.springframework.cglib.core.ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
{
  "results" : [ {
    "title" : "Sainsbury's Avocado, Ripe & Ready x2",
    "size" : "52kb",
    "unit_price" : 1.90,
    "description" : "Avocados"
  }, {
    "title" : "Sainsbury's Conference Pears, Ripe & Ready x4",
    "size" : "47kb",
    "unit_price" : 1.95,
    "description" : "Conference"
  }, {
    "title" : "Sainsbury's Mango, Ripe & Ready x2",
    "size" : "48kb",
    "unit_price" : 1.85,
    "description" : "by Sainsbury's Ripe and Ready Mango"
  }, {
    "title" : "Sainsbury's Nectarines, Ripe & Ready x4",
    "size" : "49kb",
    "unit_price" : 3.00,
    "description" : "Yellow Flesh Nectarines"
  }, {
    "title" : "Sainsbury's Kiwi Fruit, Ripe & Ready x4",
    "size" : "48kb",
    "unit_price" : 1.75,
    "description" : "Kiwi"
  }, {
    "title" : "Sainsbury's Kiwi Fruit, SO Organic x4",
    "size" : "48kb",
    "unit_price" : 1.35,
    "description" : "Organic Kiwi"
  }, {
    "title" : "Sainsbury's Pears, Ripe & Ready x4",
    "size" : "48kb",
    "unit_price" : 1.95,
    "description" : "Pear"
  }, {
    "title" : "Sainsbury's Ripe & Ready Plums x5",
    "size" : "48kb",
    "unit_price" : 2.00,
    "description" : "Plums"
  }, {
    "title" : "Sainsbury's Tree Ripened Papaya Each",
    "size" : "47kb",
    "unit_price" : 1.50,
    "description" : "Papaya"
  }, {
    "title" : "Sainsbury's White Flesh Nectarines, Ripe & Ready x4",
    "size" : "47kb",
    "unit_price" : 3.00,
    "description" : "by Sainsbury's Ripe and Ready White Flesh Nectarines"
  }, {
    "title" : "Sainsbury's Avocados, Ripe & Ready x4",
    "size" : "47kb",
    "unit_price" : 2.90,
    "description" : "Avocados"
  }, {
    "title" : "Sainsbury's Ripe & Ready Extra Large Avocados Each",
    "size" : "48kb",
    "unit_price" : 1.75,
    "description" : "Avocados"
  } ],
  "total" : 24.90
}

```

