﻿CREATE TABLE [dbo].[SANPHAM] (
  [MASP] [varchar](10) NOT NULL,
  [TENSP] [nvarchar](50) NOT NULL,
  [SL] [int] NULL CONSTRAINT [DF_SANPHAM_SL] DEFAULT (0),
  CONSTRAINT [PK_SANPHAM] PRIMARY KEY CLUSTERED ([MASP])
)
ON [PRIMARY]
GO