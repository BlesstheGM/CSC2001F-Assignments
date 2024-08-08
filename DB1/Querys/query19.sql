SELECT round(sum((priceEach * quantityOrdered)) ,2) As totalCost FROM orderdetails where ordernumber IN (SELECT orderNumber FROM orders WHERE customerNumber = 121);
