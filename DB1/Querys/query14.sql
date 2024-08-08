SELECT customerName As CustomerName, round(sum(amount), 2) As total FROM customers JOIN payments ON customers.customerNumber=payments.customerNumber WHERE City ="Paris" GROUP BY customerName HAVING count(*)>4;