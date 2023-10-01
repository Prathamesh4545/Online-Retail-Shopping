# Online-Retail-Shopping
Creating a microservice(spring boot app) for Online Retail Shoping using postman

# category Endpoints:
POST/category : For Create a new Category list
---> localhost:8080/addCategory

GET/category : Retrieve a list of all available category
---> localhost:8080/getAllCategory

# Product Endpoints:

GET /products: Retrieve a list of all available products.
---> localhost:8080/product

GET /products/{productId}: Retrieve details of a specific product by its ID.
---> localhost:8080/product/1

POST /products: Create a new product listing.
---> localhost:8080/addProduct

PUT /{productId}/products/{categoryId}: Update the details of a product where assign product by ID.
---> localhost:8080/1/products/1

PUT /products/{productId}: Update the details of a product.
--> localhost:8080/productUpdate/1

DELETE /products/{productId}: Delete a product listing.
---> localhost:8080/delete/1

GET /products/{categoryName} : Retrieve a list of all available products.
---> localhost:8080/allProduct/book


Note:- For any POST, PUT request , you can pass object through json , see e.g. below 
For Object of Product(name, price), in actual post request pass request body as {name:"abc", price:1000}
& in controller method 

@RequstMapping(method = POST)
public ResponseEntity addProduct(@RequestBody Product product) {}

# Shopping Cart Endpoints:

GET /cart: Retrieve the current user's shopping cart.
---> localhost:8080/shoppingCart

POST /cart/add/{Id}: Add a product to the shopping cart.
---> localhost:8080/cart/1

POST /{itemId}/add/{productId}: Add a cart item where gives productId and quantity.
---> localhost:8080/cartItem/1/add/1

PUT /itemId/update/{productId}: Update the quantity of a product in the cart.
---> localhost:8080/cart/1/update/1

DELETE /cart/remove/{cartItemId}: Remove a product from the cart.
---> localhost:8080/cartItem/delete/1

DELETE /cart/clear: Clear the entire shopping cart.
---> localhost:8080/deleteAllCartItem

# Order Endpoints:

POST /orders: Create a new order.
---> localhost:8080/createOrder

GET /orders/{orderId}: Retrieve details of a specific order by its ID.
---> localhost:8080/order/1

POST /addItem/{orderId}/add/{productId}: Add a order item where gives productId and quantity.
---> localhost:8080/addItem/1/add/1

GET /orders/{customer_mobile_number}: Retrieve a list of all orders placed by the specific user.
---> localhost:8080/orders/1234567890

# Payment Endpoints:

POST /payment/checkout: Initiate the checkout process and make a payment.
---> localhost:8080/payment/checkout/1

GET /payment/history: View payment history.
---> localhost:8080/payment/history

Note : Once the checkout is successful for order , quantity in stocks should be updated to quantity in stocks - reserved quantity and reserved quantity should be updated to 0;
