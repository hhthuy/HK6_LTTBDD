create database web_product_tracker
use web_product_tracker
go
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten_sp] [varchar](50) NULL,
	[gia_sp] [varchar](50) NULL,
	[nhasx] [varchar](50) NULL
	)
go
INSERT [dbo].[product] ([ten_sp], [gia_sp], [nhasx]) VALUES ( N'Milk', N'27000', N'vinamilk')
INSERT [dbo].[product] ([ten_sp], [gia_sp], [nhasx]) VALUES ( N'Cake', N'15000', N'danisa')
