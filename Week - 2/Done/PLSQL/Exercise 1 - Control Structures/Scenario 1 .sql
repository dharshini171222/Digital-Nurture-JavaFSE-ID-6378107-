-- Checking before loan discount

SELECT * from LOANS;



-- excetution of the qurrey 

SET SERVEROUTPUT ON;

DECLARE
    CURSOR senior_cust IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate, c.DOB
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
    
    v_age NUMBER;
BEGIN
    FOR rec IN senior_cust LOOP
        -- Calculate age
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = rec.InterestRate + 1
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE(
                'Customer ID ' || rec.CustomerID || ' (Age ' || v_age || '): LoanID ' || rec.LoanID || 
                ' - Interest rate reduced from ' || rec.InterestRate || ' to ' || (rec.InterestRate - 1)
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/



-- Checking loans table after changes 

SELECT * from LOANS;