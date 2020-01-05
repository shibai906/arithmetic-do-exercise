# 组合两个表
# 地址：https://leetcode-cn.com/problems/combine-two-tables/
# Person
# +-------------+---------+
# | 列名         | 类型     |
# +-------------+---------+
# | PersonId    | int     |
# | FirstName   | varchar |
# | LastName    | varchar |
# +-------------+---------+
# PersonId 是上表主键
# Address
# +-------------+---------+
# | 列名         | 类型    |
# +-------------+---------+
# | AddressId   | int     |
# | PersonId    | int     |
# | City        | varchar |
# | State       | varchar |
# +-------------+---------+
# AddressId 是上表主键
# 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：FirstName, LastName, City, State
select p.FirstName,p.LastName,a.City,a.State from Person p inner join Address a where p.PersonId=a.PersonId;

# Product Sales Analysis I
# 地址： https://leetcode-cn.com/problems/product-sales-analysis-i/
# Table:Sales
#+-------------+-------+
#| Column Name | Type  |
#+-------------+-------+
#| sale_id     | int   |
#| product_id  | int   |
#| year        | int   |
#| quantity    | int   |
#| price       | int   |
#+-------------+-------+
#(sale_id, year) is the primary key of this table.
#product_id is a foreign key to Product table.
#Note that the price is per unit.
# Table:Product
#+--------------+---------+
#| Column Name  | Type    |
#+--------------+---------+
#| product_id   | int     |
#| product_name | varchar |
#+--------------+---------+
#product_id is the primary key of this table.
#
# Write an SQL query that reports all product names of the products in the Sales table along with their selling year and price.
select p.product_name,s.year,s.price from Sales s inner join Product p on p.product_id=s.product_id
