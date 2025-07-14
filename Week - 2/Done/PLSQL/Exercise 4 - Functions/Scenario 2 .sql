-- qurrey to create a procedure 

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount     IN NUMBER,
    p_interest_rate   IN NUMBER, -- Annual in %
    p_years           IN NUMBER
) RETURN NUMBER IS
    r      NUMBER;
    n      NUMBER;
    emi    NUMBER;
BEGIN
    r := p_interest_rate / 12 / 100;
    n := p_years * 12;

    IF r = 0 THEN
        emi := p_loan_amount / n;
    ELSE
        emi := (p_loan_amount * r * POWER(1 + r, n)) / (POWER(1 + r, n) - 1);
    END IF;

    RETURN ROUND(emi, 2);
END;
/


-- 1) checking after the qurrey

SELECT 
    LoanID, 
    LoanAmount, 
    InterestRate, 
    ROUND(CalculateMonthlyInstallment(LoanAmount, InterestRate, 5), 2) AS MonthlyInstallment
FROM Loans;

-- 2) checking after the qurrey

SET SERVEROUTPUT ON;

BEGIN 
    FOR rec IN (
        SELECT LoanID, LoanAmount, InterestRate,ROUND(CalculateMonthlyInstallment(LoanAmount, InterestRate, 5), 2) AS MonthlyInstallment
        FROM Loans
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
             '(Loan ID: ' || rec.LoanID ||
             ') Loan Amount: ' || rec.LoanAmount||
             ' Rate of Intrest: ' || rec.InterestRate ||
             ' Installment : ' || rec.MonthlyInstallment
        );
    END LOOP;
END;
/