-- Cursor statmemt

SET SERVEROUTPUT ON;

DECLARE
    CURSOR monthly_curs IS
        SELECT 
            c.Name AS CustomerName,
            t.AccountID,
            t.TransactionType,
            t.Amount,
            TO_CHAR(t.TransactionDate, 'YYYY-MM-DD') AS TxnDate
        FROM 
            Transactions t
            JOIN Accounts a ON t.AccountID = a.AccountID
            JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE 
            TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM'); -- Only current month
BEGIN
    FOR txn_rec IN monthly_curs LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || txn_rec.CustomerName ||
            ', Account: ' || txn_rec.AccountID ||
            ', Type: ' || txn_rec.TransactionType ||
            ', Amount: ₹' || txn_rec.Amount ||
            ', Date: ' || txn_rec.TxnDate
        );
    END LOOP;
END;
/
