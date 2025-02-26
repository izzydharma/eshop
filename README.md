## Refleciton 1

I use some clean code priciples in this code for example like meaningful names like ```ProductController```, ```ProductService```, and ```createProductPage``` that clearly describe their purpose. also It follows the Single Responsibility Principle, where each class has a distinct role, for example ```ProductController``` handles HTTP requests. The DRY (Don't Repeat Yourself) principle is applied by avoiding code duplication, as seen in ```ProductServiceImpl```, which uses ```ProductRepository``` for CRUD operations. Additionally, the code is consistently formatted with proper indentation and spacing. Secure coding practices are also implemented, such as using dependency injection via Spring's ```@Autowired``` annotation for better dependency management and testability, and handling exceptions appropriately, such as throwing runtime exceptions for missing products during updates. However, improvements can be made in error handling by introducing custom exceptions like ```ProductNotFoundException``` and global exception handlers. Furthermore, input validation in ```ProductController``` methods should be enhanced by using annotations like ```@Valid``` and ```@NotNull``` to prevent processing invalid data.

## Reflection 2

1. It feels reasuring to know that the code i just worked on worked as intended after writing the unit test. For each class, i feel like it's best to write a few test for it to cover all possibilities that might
happen. Having 100% coverage on your code doesn't mean that the code is bug free, it just means that each line of code is already executed by tests but there could be still bugs left in the source code.

2. Creating a new functional test suite similar to CreateProductFunctionalTest.java can lower code quality due to duplicated setup, variables, and methods. This repetition makes the code harder to maintain, as
updates in shared logic need to be made in multiple places, increasing the risk of errors. It also reduces readability and can lead to inconsistent or fragile tests. To improve, shared logic should be moved to a
base class or utility methods. These changes make the tests cleaner and easier to maintain.

## Reflection 3

1. I fixed a code duplication problem in my ProductController where it have a duplicate literal, so i make a variable for that literal and the all of the fucntion that refers to that literal uses the variable instead. I fixed assesrtion to the testDeleteNonExistentProduct(). I deleted a not used insertion org.junit.jupiter.api.Assertions.assertNotNull. Not hardcoding version number fixed by setting a variable to the code version and calling it for the dependecies. Removed the declaration of thrown exception 'java.lang.Exception', as it cannot be thrown from method's body.

2. The workflows automatically run tests on every push or pull request, ensuring that new code is frequently integrated and verified. THe source code also include an automated deployment process that triggers on updates to the main branch, enabling changes to rapidly reach the production environment. These features match the typical definition of Continuous Integration and Continuous Deployment by automating build, test, and release steps.

## Reflection 4

### 1) SOLID Principles Applied

- **Single Responsibility Principle (SRP):**  
  Each class in the project has a clear responsibility. For example, the ProductController only handles product-related HTTP requests and delegates business logic to the service layer.

- **Open/Closed Principle (OCP):**  
  Classes and components are designed to be open for extension but closed for modification. For example, when adding new features or behaviors to products, we can extend existing services (like ProductServiceImpl) without changing the core functionality.

- **Liskov Substitution Principle (LSP):**  
  The implementation classes (such as ProductServiceImpl without affecting the correctness of the application.

- **Interface Segregation Principle (ISP):**  
  The project separates interfaces by specific tasks. Instead of one big interface, we have smaller and more focused interfaces. For example, CarService extends several smaller interfaces, each defining a specific set of behaviors for creation, retrieval, update, and deletion.

- **Dependency Inversion Principle (DIP):**  
  High-level modules (like controllers) do not depend on low-level modules (concrete implementations) but rather on abstractions such as ProductService. This design decision is evident in the controllers which rely on interface-based autowiring provided by Spring.

### 2) Advantages of Applying SOLID Principles

- **Easier Maintenance:**  
  With SRP, each class has a focused role. For example, if you need to update the product handling logic, you only need to modify the service layer rather than update a monolithic controller.

- **Scalability and Flexibility:**  
  OCP allows the project to add new features without modifying existing code. If a new payment method is needed, you can introduce a new service extension without affecting the current system.

- **Simplified Testing:**  
  Thanks to DIP, controllers depend on abstractions which can be easily mocked during testing. This improves testability and helps isolate bugs.

- **Enhanced Code Reusability:**  
  With ISP, classes implement only the necessary methods. This minimizes unwanted dependencies, making it easier to reuse components in different parts of the project.

### 3) Disadvantages of Not Applying SOLID Principles

- **Tight Coupling:**  
  Without DIP and ISP, controllers might directly instantiate concrete services which can lead to a rigid, hard-to-change codebase. For instance, modifying product behavior would require changes in multiple locations.

- **Reduced Maintainability:**  
  Ignoring SRP could lead to classes doing too much. If the ProductController.java also started handling business logic or data access, it would become cumbersome to maintain or extend.

- **Testing Challenges:**  
  A lack of DIP may force tests to interact with complex, fully implemented dependencies, making unit tests harder to write and maintain. This could result in less reliable test suites.

- **Inflexible System Design:**  
  Without OCP, any new feature might necessitate changes in existing, stable classes. This increases the risk of introducing bugs in areas that were previously working, slowing down development.

---

By adhering to SOLID principles, the project becomes more maintainable, modular, and easier to test. In contrast, neglecting these principles results in a tightly coupled and fragile codebase that is difficult to scale and maintain.
