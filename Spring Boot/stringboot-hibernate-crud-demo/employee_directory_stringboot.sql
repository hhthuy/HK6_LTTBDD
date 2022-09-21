create database employee_directory
GO
use employee_directory

CREATE TABLE [dbo].[employee](
	id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	first_name nvarchar(50) NULL,
	last_name nvarchar(50) NULL,
	email nvarchar(100) NULL,
)
GO

INSERT INTO [dbo].[employee] ([first_name], [last_name], [email]) 
VALUES 
(N'ho', N'hong thuy', N'hohongthuy001@gmail.com'),
(N'tran', N'thi a', N'tranthia@gmail.com'),
(N'vo', N'minh b', N'vominhb@gmail.com'),
(N'pham', N'thanh c', N'phamthanhc@gmail.com'),
(N'phan', N'van d', N'phanvand@gmail.com')