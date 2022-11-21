﻿CREATE TABLE [dbo].[CHITIETPHIEU] (
  [MAPHIEU] [varchar](10) NOT NULL,
  [STT] [int] NOT NULL,
  [MASP] [varchar](10) NOT NULL,
  [SL] [int] NOT NULL CONSTRAINT [DF_CHITIETPHIEU_SL] DEFAULT (0),
  [GHICHU] [nvarchar](100) NULL,
  CONSTRAINT [PK_CHITIETPHIEU] PRIMARY KEY CLUSTERED ([MAPHIEU], [STT])
)
ON [PRIMARY]
GO

ALTER TABLE [dbo].[CHITIETPHIEU]
  ADD CONSTRAINT [FK_CHITIETPHIEU_ACTHIST] FOREIGN KEY ([MAPHIEU]) REFERENCES [dbo].[PHIEUNHAPXUAT] ([MAPHIEU])
GO

ALTER TABLE [dbo].[CHITIETPHIEU]
  ADD CONSTRAINT [FK_CHITIETPHIEU_SANPHAM] FOREIGN KEY ([MASP]) REFERENCES [dbo].[SANPHAM] ([MASP]) ON UPDATE CASCADE
GO