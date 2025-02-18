## Refleciton 1

I use some clean code priciples in this code for example like meaningful names like ```ProductController```, ```ProductService```, and ```createProductPage``` that clearly describe their purpose. also It follows the Single Responsibility Principle, where each class has a distinct role, for example ```ProductController``` handles HTTP requests. The DRY (Don't Repeat Yourself) principle is applied by avoiding code duplication, as seen in ```ProductServiceImpl```, which uses ```ProductRepository``` for CRUD operations. Additionally, the code is consistently formatted with proper indentation and spacing. Secure coding practices are also implemented, such as using dependency injection via Spring's ```@Autowired``` annotation for better dependency management and testability, and handling exceptions appropriately, such as throwing runtime exceptions for missing products during updates. However, improvements can be made in error handling by introducing custom exceptions like ```ProductNotFoundException``` and global exception handlers. Furthermore, input validation in ```ProductController``` methods should be enhanced by using annotations like ```@Valid``` and ```@NotNull``` to prevent processing invalid data.

## Reflection 2

1. It feels reasuring to know that the code i just worked on worked as intended after writing the unit test. For each class, i feel like it's best to write a few test for it to cover all possibilities that might
happen. Having 100% coverage on your code doesn't mean that the code is bug free, it just means that each line of code is already executed by tests but there could be still bugs left in the source code.

2. Creating a new functional test suite similar to CreateProductFunctionalTest.java can lower code quality due to duplicated setup, variables, and methods. This repetition makes the code harder to maintain, as
updates in shared logic need to be made in multiple places, increasing the risk of errors. It also reduces readability and can lead to inconsistent or fragile tests. To improve, shared logic should be moved to a
base class or utility methods. These changes make the tests cleaner and easier to maintain.

## Reflection 3

1. I fixed a code duplication problem in my ProductController where it have a duplicate literal, so i make a variable for that literal and the all of the fucntion that refers to that literal uses the variable instead.
   
2. The workflows automatically run tests on every push or pull request, ensuring that new code is frequently integrated and verified. THe source code also include an automated deployment process that triggers on updates to the main branch, enabling changes to rapidly reach the production environment. These features match the typical definition of Continuous Integration and Continuous Deployment by automating build, test, and release steps.
