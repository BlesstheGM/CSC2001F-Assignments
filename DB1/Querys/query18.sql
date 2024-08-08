SELECT e.email
FROM employees e
JOIN (
    SELECT salesRepEmployeeNumber, COUNT(customerNumber) AS num_customers
    FROM customers
    GROUP BY salesRepEmployeeNumber
) AS sales_rep_counts ON e.employeeNumber = sales_rep_counts.salesRepEmployeeNumber
JOIN (
    SELECT COUNT(customerNumber) AS num_customers
    FROM customers
    WHERE salesRepEmployeeNumber = 1166
) AS emp_1166_counts ON sales_rep_counts.num_customers < emp_1166_counts.num_customers
WHERE e.jobTitle = 'Sales Rep';
