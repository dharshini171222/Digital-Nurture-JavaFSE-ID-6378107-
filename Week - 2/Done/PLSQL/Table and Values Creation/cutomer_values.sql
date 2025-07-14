INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1959-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);  -- Age 65

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Carlos Rivera', TO_DATE('1982-09-10', 'YYYY-MM-DD'), 1200, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (4, 'Emily Clark', TO_DATE('1995-12-03', 'YYYY-MM-DD'), 1100, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (5, 'Ravi Kumar', TO_DATE('1988-03-25', 'YYYY-MM-DD'), 10500, SYSDATE);  -- Balance > 10000

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (6, 'Sara Lee', TO_DATE('1993-08-17', 'YYYY-MM-DD'), 1300, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (7, 'Mark Wilson', TO_DATE('1980-01-22', 'YYYY-MM-DD'), 15000, SYSDATE);  -- Balance > 10000

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (8, 'Angela White', TO_DATE('1956-11-08', 'YYYY-MM-DD'), 800, SYSDATE);  -- Age 68

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (9, 'Tom Hanks', TO_DATE('1962-06-30', 'YYYY-MM-DD'), 1050, SYSDATE);  -- Age 62

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (10, 'Nina Dobrev', TO_DATE('1989-10-10', 'YYYY-MM-DD'), 12000, SYSDATE); -- Balance > 10000

SELECT * from CUSTOMERS;