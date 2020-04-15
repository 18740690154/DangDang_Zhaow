select f.id,f.cate_name,f.count,f.parent_id,f.levels,
	 	 	   s.id,s.cate_name,s.count,s.parent_id,s.levels 
	 	from d_category f 
	 	left join d_category s
	 	on f.parent_id =s.id 
where s.id ='1'

select b.id b_id ,b.cate_id bcate_id ,c.id c_id
			from d_book  b
			left join d_category c
			on b.cate_id = c.id
			where c.id = '4193a069-f922-4648-a31b-343e162a254e'	


select * from (select * from d_book order by dbms_random.value) where rownum < 7


	select *
	 		from (select * 	from d_book
	 				where sale_count != 0
	 			order by sale_count desc)
	 	where rownum < 7
	 	
	 	
	 	select   *
			from (select *  from  d_book order by publish_time desc)	
			where rownum < 7 
			
			
		select *
			from (select *from 
			(select * from d_book  
				 where sale_count != 0
				 order by sale_count desc)	
				order by publish_time desc)
			where rownum < 11 		
	
	select  * from  d_book b
		left join  d_category  c
		on  b.cate_id =c.id
 	where c.parent_id ='29bf1e9e-d06a-47b8-b186-7d320fd6418c'
												 	