-- qurrey to create a procedure 

CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/


-- 1) checking after the qurrey

SELECT Name, DOB, CalculateAge(DOB) AS Age
FROM Customers;

-- 2) checking after the qurrey

SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT CustomerID, Name, DOB
        FROM Customers
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || rec.Name ||
            ' (ID: ' || rec.CustomerID || 
            ') - Age: ' || CalculateAge(rec.DOB)
        );
    END LOOP;
END;
/