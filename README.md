# shopping-backend
A simple e-commerce project's backend.
> https://shopping-backend-sparkjava.herokuapp.com/api/getProducts?limit=45&offset=10 <-- Click this. To see it in action!

| API Endpoint | Description |
| --- | --- |
| [/api/getProducts?**limit=45**&**offset=10**](https://shopping-backend-sparkjava.herokuapp.com/api/getProducts?limit=45&offset=10) | To return an array of products containing `limit` number of products, **FROM** `offset`<br><br> __*Example:*__ limit = 10, offset = 0, will return products from ID 0 to ID 9(If the database dosen't have enough products, let's say the system has 5 products, and limit = 10, offset = 1, then it will return an array of products from ID 1 to ID 4, and the last element of that array will be a message stating <code>Database limit exceeded</code>)<br><br> It may return error if `limit` and `offset` are not positive integers |
| [/api/getAllProducts](https://shopping-backend-sparkjava.herokuapp.com/api/getAllProducts) | To return an array containing all products |
| /api/beta/tokenSignIn | To sign-in(or register) the user, with the `id_token` as a `POST` variable.(This system is using Google's OAuth2.0(see : https://developers.google.com/identity/sign-in/web/backend-auth))<br><br> It will create a new session and return `User signed-in`(if there are no errors)<br><br> It may return an internal server error, OAuth verification failed. These errors are self explanatory.<br><br> If a previously registered user tries to log-in, then it will invalidate the previous session, and create a new one and return `User signed-in` |
| /api/beta/signOut | Invalidates the session and returns `User signed-out` |
| /api/beta/deleteUser | Invalidates the session, deletes the user from the database and returns `User deleted` |
| /api/beta/addToCart?productID=45 | Adds an item(in this case, the item of product ID 45) to the cart<br><br> It may return `Unauthorized`, if the user has not logged-in or registered. It may return errors, if the query parameter(productID=...) is not a positive integer, and it must not exceed the number of products in the database |
| /api/beta/getUser | Returns the data stored in the database about the user<br><br> It may return `Unauthorized`, if the user is not logged-in or registered |
