Steps and flow of the project.

1. Register customers ( buyer, seller, delivery boys, admin ). Entry goes in CUSTOMERS table.
2. An GUI for admin to enter items. Entry goes into ITEMS table.
3. A web based mobile phone GUI to place order by the buyer, one order will contain atleast one item. Entry goes into the ORDERS and ORDERITEMS table.
4. A GUI to login by the customers. 
5. A buyer place order with many items, admin will view orders on orders page, admin will assign order to delivery person, delivery person ask money
from owner, owner enters the amount in DELIVERY_CUST_ACCOUNT table in amountPaid field, delivery person purchase the goods and deliver to 
the customer address, delivery person recives money from the buyer (amount of total items + delivery charges), delivery person gives money to the owner, 
owner enters amount in DELIVERY_CUST_ACCOUNT table in amountReceived field. A GUI will show the profit or loss per order per delivery person.
6. A GUI to assign order to delivery person.
7. A GUI to enter amount paid/recived to/from delivery person by owner.
8. A GUI to view my orders by buyer.
9. A GUI to view all the assigned orders to the particular delivery person.
10. A GUI to view all the orders on the basis of city/colony/street name.
11. A GUI to update the order state from pending to delivered.
12. A GUI to view total profit or loss weekly, monthly, from start date to end date.
