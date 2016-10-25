CREATE OR REPLACE PROCEDURE check_freq (
    pt_id      IN VARCHAR2,
    date_now   IN TIMESTAMP
) AS
    alert_count   NUMBER;
BEGIN
    SELECT
        COUNT(*) 
    INTO
        alert_count
    FROM
        alert;

    DECLARE
        CURSOR c1 IS
            SELECT
                concat(
                    'Alert generated due to low frequency for the measure of ',
                    concat(
                        r1.description,
                        concat(
                            '. Recommended is once in ',
                            concat(r1.frequency,concat(' day(s). But you last entered on ',TO_CHAR(o1.ob_time) ) )
                        )
                    )
                ) AS de, R1.r_id
            FROM
                record_disease rd1,
                standard_recommendation sr1,
                recommendation r1,
                observation o1
            WHERE
                pt_id = rd1.p_id
            AND
                rd1.d_id = sr1.d_id
            AND
                sr1.r_id = r1.r_id
            AND
                o1.p_id = pt_id
            AND
                o1.r_id = r1.r_id
            AND
            
            o1.ob_time + to_number(r1.frequency) <= date_now
                --( to_number(TO_CHAR(o1.ob_time,'DD') ) + to_number(r1.frequency) ) <= date_now
            AND
                ( to_number(TO_CHAR(o1.ob_time,'DD') ) + to_number(r1.frequency) ) > ALL (
                    SELECT
                        to_number(TO_CHAR(o2.ob_time,'DD') )
                    FROM
                        observation o2
                    WHERE
                        o2.r_id = r1.r_id
                    AND
                        o2.p_id = pt_id
                );

    BEGIN
        FOR item IN c1 LOOP
            INSERT INTO alert VALUES (
                alert_count + 1,
                pt_id,
                item.r_id,
                item.de,
                'T',
                'F'
            );

            alert_count := alert_count + 1;
        END LOOP;

    END;

END;

--SET SERVEROUTPUT ON;

--BEGIN
--    check_freq('P1',sysdate);
--END;
--/