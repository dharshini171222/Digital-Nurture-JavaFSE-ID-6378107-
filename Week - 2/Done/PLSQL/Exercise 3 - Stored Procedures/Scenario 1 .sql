-- checking before the qurrey

SELECT * FROM Accounts WHERE AccountType = 'Savings';


-- qurrey to create a procedure 

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_new_balance Accounts.Balance%TYPE;
BEGIN
    FOR rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
        FOR UPDATE
    ) LOOP
        v_new_balance := rec.Balance + (rec.Balance * 0.01);

        UPDATE Accounts
        SET Balance = v_new_balance
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Interest applied: Account ID ' || rec.AccountID ||
            ', Old Balance: $' || rec.Balance ||
            ', New Balance: $' || TO_CHAR(v_new_balance, '9999990.99')
        );
    END LOOP;

    COMMIT;
END;
/


-- running procedure

EXEC ProcessMonthlyInterest;


-- checking after the qurrey

SELECT * FROM Accounts WHERE AccountType = 'Savings';