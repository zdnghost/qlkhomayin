﻿CREATE TABLE [dbo].[PHIEUNHAPXUAT] (
  [MAPHIEU] [varchar](10) NOT NULL,
  [XUATNHAP] [bit] NOT NULL,
  [NGAY] [datetime] NOT NULL,
  [USERNAME] [nchar](20) NOT NULL,
  CONSTRAINT [PK_LSXUATNHAP] PRIMARY KEY CLUSTERED ([MAPHIEU])
)
ON [PRIMARY]
GO

ALTER TABLE [dbo].[PHIEUNHAPXUAT]
  ADD CONSTRAINT [FK_ACTHIST_USER] FOREIGN KEY ([USERNAME]) REFERENCES [dbo].[USERDB] ([USERNAME])
GO