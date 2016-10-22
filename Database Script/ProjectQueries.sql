--    List the number of health supporters that were authorized in the month of September 2016 by patients suffering from heart disease.
select * from sick_person where (P_ID in (select P_ID from RECORD_DISEASE where D_ID in (select D_ID from Disease where UPPER(DNAME) = 'HEART DISEASE'))) 
and (to_char(hs1_auth_date) = '102016' or to_char(hs2_auth_date )= '102016');

--    Give the number of patients who were not complying with the recommended frequency of recording observations.


--    List the health supporters who themselves are patients.
select * from sick_person where p_id = HS1_ID or p_id = HS2_ID;

--    List the patients who are not ‘sick’.
select * from PERSON where P_ID not in (select P_ID from SICK_PERSON);

--    How many patients have different observation time and recording time (of the observation).
select count(P_ID) from RECORD_OBSERVATION where (RECORD_TIME <> OB_TIME);