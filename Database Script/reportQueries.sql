--List the number of health supporters that were authorized in the month of September 2016 by patients suffering from heart disease.
select count(*)
from sick_person
where (P_ID in (select P_ID from RECORD_DISEASE where D_ID in (select D_ID from Disease where UPPER(DNAME) = 'HEART DISEASE'))) 
      and (to_char(hs1_auth_date,'MM') = '09' or to_char(hs2_auth_date, 'MM')= '09');


--    Give the number of patients who were not complying with the recommended frequency of recording observations.


--    List the health supporters who themselves are patients.
select SP1.p_id, P.pname
from sick_person SP1, sick_person SP2, person P
where (SP1.p_id = SP2.HS1_ID or SP1.p_id = SP2.HS2_ID) and SP1.p_id = P.p_id;


--    List the patients who are not ‘sick’.
select * 
from PERSON
where P_ID not in (select P_ID from SICK_PERSON);


--    How many patients have different observation time and recording time (of the observation).
select count(P_ID)
from RECORD_OBSERVATION
where (RECORD_TIME <> OB_TIME);