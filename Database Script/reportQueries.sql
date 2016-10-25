--    List the number of health supporters that were authorized in the month of September 2016 by patients suffering from heart disease.
select count(*) from sick_person where (P_ID in (select P_ID from RECORD_DISEASE where D_ID in (select D_ID from Disease where UPPER(DNAME) = 'HEART DISEASE'))) 
and (to_char(hs1_auth_date) = '102016' or to_char(hs2_auth_date )= '102016');

--    Give the number of patients who were not complying with the recommended frequency of recording observations.
define dateToCheckForFrequency = to_number(to_char(sysdate, 'DD'))

select SP1.p_id, R1.r_id, to_char(RO1.ob_time) as Took_On, R1.description, concat((to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)), substr(to_char(RO1.ob_time), 3,25) ) as Had_To_Take_Next_On, 'Yes' as Sick_Person, 'No' as Well_Person, 'Yes' as Standard_Recommendation, 'No' as Specific_Recommendation
from  sick_person SP1, STANDARD_RECOMMENDATION SR1,  RECORD_DISEASE RD1, RECOMMENDATION R1, OBSERVATION O1, RECORD_OBSERVATION RO1
where SP1.p_id = RD1.p_id and RD1.d_id = SR1.d_id and R1.r_id = SR1.r_id and O1.r_id = R1.r_id and RO1.ob_id = O1.ob_id and RO1.p_id = SP1.p_id and 
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) <= &dateToCheckForFrequency and
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) not in (
select to_number(to_char(RO2.ob_time, 'DD'))
from  OBSERVATION O2, RECORD_OBSERVATION RO2
where O2.r_id = R1.r_id and RO2.ob_id = O2.ob_id and RO2.p_id = SP1.p_id)

union 

select SP1.p_id, R1.r_id, to_char(RO1.ob_time) as Took_On, R1.description, concat((to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)), substr(to_char(RO1.ob_time), 3,25) ) as Had_To_Take_Next_On, 'Yes' as Sick_Person, 'No' as Well_Person, 'No' as Standard_Recommendation, 'Yes' as Specific_Recommendation
from  sick_person SP1, SPECIFIC_RECOMMENDATION SPR1, RECOMMENDATION R1, OBSERVATION O1, RECORD_OBSERVATION RO1
where SP1.p_id = SPR1.p_id and R1.r_id = SPR1.r_id and O1.r_id = R1.r_id and RO1.ob_id = O1.ob_id and RO1.p_id = SP1.p_id and 
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) <= &dateToCheckForFrequency and
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) not in (
select to_number(to_char(RO2.ob_time, 'DD'))
from   OBSERVATION O2, RECORD_OBSERVATION RO2
where R1.r_id = SPR1.r_id and O2.r_id = R1.r_id and RO2.ob_id = O2.ob_id and RO2.p_id = SP1.p_id)


union

select WP1.p_id, R1.r_id, to_char(RO1.ob_time) as Took_On, R1.description, concat((to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)), substr(to_char(RO1.ob_time), 3,25) ) as Had_To_Take_Next_On, 'No' as Sick_Person, 'Yes' as Well_Person, 'No' as Standard_Recommendation, 'Yes' as Specific_Recommendation
from  well_person WP1, SPECIFIC_RECOMMENDATION SPR1, RECOMMENDATION R1, OBSERVATION O1, RECORD_OBSERVATION RO1
where WP1.p_id = SPR1.p_id and R1.r_id = SPR1.r_id and O1.r_id = R1.r_id and RO1.ob_id = O1.ob_id and RO1.p_id = WP1.p_id and 
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) <= &dateToCheckForFrequency and
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) not in (
select to_number(to_char(RO2.ob_time, 'DD'))
from   OBSERVATION O2, RECORD_OBSERVATION RO2
where R1.r_id = SPR1.r_id and O2.r_id = R1.r_id and RO2.ob_id = O2.ob_id and RO2.p_id = WP1.p_id);



--    List the health supporters who themselves are patients.
select * from person where P_id in (select p_id from sick_person where p_id in ((select hs1_id as p_id from sick_person) union (select hs1_id as p_id from WELL_PERSON)) or p_id in ((select hs2_id as p_id from sick_person) union (select hs2_id as p_id from WELL_PERSON)));

--    List the patients who are not ‘sick’.
select * from PERSON where P_ID not in (select P_ID from SICK_PERSON);

--    How many patients have different observation time and recording time (of the observation).
select count(P_ID) from OBSERVATION where (RECORD_TIME <> OB_TIME);
