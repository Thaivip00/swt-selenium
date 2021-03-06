USE [master]
GO
/****** Object:  Database [UserManagement]    Script Date: 6/15/2022 5:31:32 PM ******/
CREATE DATABASE [UserManagement]
USE [UserManagement]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 6/15/2022 5:31:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [nvarchar](50) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NULL,
	[status] [bit] NULL,
)

INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status]) VALUES (N'admin', N'Team 3 - SE1622', N'123', N'AD', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status]) VALUES (N'Hoadnt', N'Hoa Doan', N'1', N'US', 0)
GO

