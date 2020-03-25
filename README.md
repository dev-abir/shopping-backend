# shopping-backend
A simple e-commerce project's backend.
> https://shopping-backend-sparkjava.herokuapp.com/api/getProducts?limit=45&offset=10 <-- Click this. To see it in action!

| API Endpoint | Description |
| --- | --- |
| [/api/getProducts?**limit=45**&**offset=10**](https://shopping-backend-sparkjava.herokuapp.com/api/getProducts?limit=45&offset=10) | To return an array of products containing `limit` number of products, **FROM**                `offset`<br><br> <p>__*Example:*__ limit = 10, offset = 0, will return products from ID 0 to ID 9(If the database dosen't have enough products, let's say the system has 5 products, and limit = 10, offset = 1, then it will return an array of products from ID 1 to ID 4, and the last element of that array will be a message stating <code>Database limit exceeded</code>)</p> |
| [api/getAllProducts](https://shopping-backend-sparkjava.herokuapp.com/api/getAllProducts) | To return an array containing all products |
