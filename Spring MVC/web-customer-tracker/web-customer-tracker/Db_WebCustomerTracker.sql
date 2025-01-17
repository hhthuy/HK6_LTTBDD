USE [master]
GO
/****** Object:  Database [web_customer_tracker]    Script Date: 4/9/2021 1:26:53 PM ******/
CREATE DATABASE [web_customer_tracker]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'web_customer_tracker', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\web_customer_tracker.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'web_customer_tracker_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\web_customer_tracker_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [web_customer_tracker] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [web_customer_tracker].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [web_customer_tracker] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [web_customer_tracker] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [web_customer_tracker] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [web_customer_tracker] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [web_customer_tracker] SET ARITHABORT OFF 
GO
ALTER DATABASE [web_customer_tracker] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [web_customer_tracker] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [web_customer_tracker] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [web_customer_tracker] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [web_customer_tracker] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [web_customer_tracker] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [web_customer_tracker] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [web_customer_tracker] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [web_customer_tracker] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [web_customer_tracker] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [web_customer_tracker] SET  DISABLE_BROKER 
GO
ALTER DATABASE [web_customer_tracker] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [web_customer_tracker] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [web_customer_tracker] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [web_customer_tracker] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [web_customer_tracker] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [web_customer_tracker] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [web_customer_tracker] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [web_customer_tracker] SET RECOVERY FULL 
GO
ALTER DATABASE [web_customer_tracker] SET  MULTI_USER 
GO
ALTER DATABASE [web_customer_tracker] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [web_customer_tracker] SET DB_CHAINING OFF 
GO
ALTER DATABASE [web_customer_tracker] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [web_customer_tracker] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'web_customer_tracker', N'ON'
GO
USE [web_customer_tracker]
GO
/****** Object:  User [springstudent]    Script Date: 4/9/2021 1:26:53 PM ******/
CREATE USER [springstudent] FOR LOGIN [springstudent] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [springstudent]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [springstudent]
GO
ALTER ROLE [db_datareader] ADD MEMBER [springstudent]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [springstudent]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 4/9/2021 1:26:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](50) NULL,
	[last_name] [varchar](50) NULL,
	[email] [varchar](50) NULL,
 CONSTRAINT [PK_customer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[customer] ON 

INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (2, N'John', N'Doe', N'john@secode.com')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (4, N'Mary', N'Public', N'mary@secode.com')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (1002, N'John 2', N'Doe', N'john@commail.se')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (1003, N'David', N'Gueta', N'Gueta@secode.com')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (1004, N'Pham', N'Quang', N'phamquangtri@gmail.com')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (1005, N'Trung', N'Tran', N'tran@gmail.com')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (1006, N'Kien', N'Le', N'le@gmail.com')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (1007, N'Minh', N'Pham', N'pham@gmail.com')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (3005, N'Thanh', N'Tran', N'thanh@mail.com')
INSERT [dbo].[customer] ([id], [first_name], [last_name], [email]) VALUES (3006, N'Minh', N'Pham', N'minh@mail.com')
SET IDENTITY_INSERT [dbo].[customer] OFF
USE [master]
GO
ALTER DATABASE [web_customer_tracker] SET  READ_WRITE 
GO
