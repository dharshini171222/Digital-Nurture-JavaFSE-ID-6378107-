-- Table before qurrey
SELECT * FROM Loans ;


-- CURSOR creation 

SET SERVEROUTPUT ON;

DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans
        FOR UPDATE;

    v_new_rate Loans.InterestRate%TYPE;
BEGIN
    FOR rec IN loan_cursor LOOP
        IF rec.LoanAmount > 10000 THEN
            v_new_rate := rec.InterestRate - 1;
        ELSE
            v_new_rate := rec.InterestRate + 0.5;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'Loan ID: ' || rec.LoanID ||
            ' | Old Rate: ' || rec.InterestRate || '%' ||
            ' | New Rate: ' || v_new_rate || '%'
        );
    END LOOP;

    COMMIT;
END;
/



-- Table after qurrey
SELECT * FROM Loans ;