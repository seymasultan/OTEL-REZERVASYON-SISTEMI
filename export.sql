--------------------------------------------------------
--  File created - Pazar-Aralýk-29-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DEMO_CUST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."DEMO_CUST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORDER_ITEMS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."DEMO_ORDER_ITEMS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."DEMO_ORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 11 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_PROD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."DEMO_PROD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."DEMO_USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DENEME_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."DENEME_SEQ"  MINVALUE 1 MAXVALUE 99999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MUSTERI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."MUSTERI_SEQ"  MINVALUE 1 MAXVALUE 99999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence ODALAR_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."ODALAR_SEQ"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OTELLER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."OTELLER_SEQ"  MINVALUE 1 MAXVALUE 99999999999999 INCREMENT BY 1 START WITH 57 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REZERVASYON_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."REZERVASYON_SEQ"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SEHIR
--------------------------------------------------------

   CREATE SEQUENCE  "GAZI1"."SEQ_SEHIR"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 44 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table MUSTERILER
--------------------------------------------------------

  CREATE TABLE "GAZI1"."MUSTERILER" 
   (	"AD" VARCHAR2(20 BYTE), 
	"SOYAD" VARCHAR2(20 BYTE), 
	"TELEFON" VARCHAR2(15 BYTE), 
	"KIMLIK" NUMBER(11,0), 
	"PAROLA" VARCHAR2(20 BYTE), 
	"MUSTERI_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ODALAR
--------------------------------------------------------

  CREATE TABLE "GAZI1"."ODALAR" 
   (	"ODA_ID" NUMBER, 
	"ODA_TIPI" VARCHAR2(20 BYTE), 
	"OTEL_ID" NUMBER, 
	"FIYAT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table OTELLER
--------------------------------------------------------

  CREATE TABLE "GAZI1"."OTELLER" 
   (	"OTEL_ID" NUMBER, 
	"OTEL_ADI" VARCHAR2(20 BYTE), 
	"SEHIR_ID" NUMBER(2,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REZERVASYONLAR
--------------------------------------------------------

  CREATE TABLE "GAZI1"."REZERVASYONLAR" 
   (	"GIRIS_TARIHI" VARCHAR2(20 BYTE), 
	"CIKIS_TARIHI" VARCHAR2(20 BYTE), 
	"ODA_ID" NUMBER, 
	"MUSTERI_ID" NUMBER, 
	"REZERVASYON_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SEHIRLER
--------------------------------------------------------

  CREATE TABLE "GAZI1"."SEHIRLER" 
   (	"SEHIR_ID" NUMBER(*,0), 
	"SEHIR_ADI" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table YONETICI
--------------------------------------------------------

  CREATE TABLE "GAZI1"."YONETICI" 
   (	"YONETICI_ADI" VARCHAR2(20 BYTE), 
	"PAROLA" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for View STAFFPROPLIST
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "GAZI1"."STAFFPROPLIST" ("BRANCHNO", "STAFFNO", "PROPERTYNO") AS 
  SELECT s.branchNo, s.staffNo, p.propertyNo 
FROM Staff s, PropertyForRent p 
WHERE s.staffNo = p.staffNo;
--------------------------------------------------------
--  DDL for View STAFF3
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "GAZI1"."STAFF3" ("STAFFNO", "FNAME", "INAME", "POSITION", "SEX") AS 
  SELECT staffNo, fName, IName, position, sex
FROM Staff
WHERE branchNo = 'B003';
REM INSERTING into GAZI1.MUSTERILER
SET DEFINE OFF;
Insert into GAZI1.MUSTERILER (AD,SOYAD,TELEFON,KIMLIK,PAROLA,MUSTERI_ID) values ('KAÐAN','SÖZEN','05670351879','23945614785','15236','61');
Insert into GAZI1.MUSTERILER (AD,SOYAD,TELEFON,KIMLIK,PAROLA,MUSTERI_ID) values ('YAÐMUR','DÝLA','05442392348','14526879431','012','62');
Insert into GAZI1.MUSTERILER (AD,SOYAD,TELEFON,KIMLIK,PAROLA,MUSTERI_ID) values ('SEYMA','SÖZEN','55066981909','11111111111','111','6');
Insert into GAZI1.MUSTERILER (AD,SOYAD,TELEFON,KIMLIK,PAROLA,MUSTERI_ID) values ('CÝHAT','CÜNÝ','54351487030','23561485025','2222','9');
REM INSERTING into GAZI1.ODALAR
SET DEFINE OFF;
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('62','Dört Kiþilik','4','500');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('63','Dört Kiþilik','7','450');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('61','Dört Kiþilik','3','400');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('64','Dört Kiþilik','9','375');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('65','Dört Kiþilik','10','425');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('66','Dört Kiþilik','11','575');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('4','Üç Kiþilik','1','400');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('5','Tek Kiþilik','1','150');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('6','Dört Kiþilik','1','500');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('8','Ýki Kiþilik','2','250');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('9','Üç Kiþilik','2','400');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('2','Ýki Kiþilik','1','250');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('10','Dört Kiþilik','2','500');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('11','Tek Kiþilik','2','150');
Insert into GAZI1.ODALAR (ODA_ID,ODA_TIPI,OTEL_ID,FIYAT) values ('23','Dört Kiþilik','6','600');
REM INSERTING into GAZI1.OTELLER
SET DEFINE OFF;
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('1','Hilton Otel','1');
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('2','Golden Rose Otel','1');
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('3','Ýnci Otel','2');
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('6','Anemon Otel','3');
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('7','Ramada Otel','3');
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('9','Park Royal Otel','4');
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('10','Golden Lake Otel','4');
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('11','Samos Otel','4');
Insert into GAZI1.OTELLER (OTEL_ID,OTEL_ADI,SEHIR_ID) values ('4','Avanos Otel','2');
REM INSERTING into GAZI1.REZERVASYONLAR
SET DEFINE OFF;
Insert into GAZI1.REZERVASYONLAR (GIRIS_TARIHI,CIKIS_TARIHI,ODA_ID,MUSTERI_ID,REZERVASYON_ID) values ('2019-12-20','2019-12-22','5','6','22');
Insert into GAZI1.REZERVASYONLAR (GIRIS_TARIHI,CIKIS_TARIHI,ODA_ID,MUSTERI_ID,REZERVASYON_ID) values ('2019-12-3','2019-12-6','23','9','23');
Insert into GAZI1.REZERVASYONLAR (GIRIS_TARIHI,CIKIS_TARIHI,ODA_ID,MUSTERI_ID,REZERVASYON_ID) values ('2019-12-3','2019-12-6','61','9','24');
Insert into GAZI1.REZERVASYONLAR (GIRIS_TARIHI,CIKIS_TARIHI,ODA_ID,MUSTERI_ID,REZERVASYON_ID) values ('2019-12-29','2019-12-30','9','6','41');
Insert into GAZI1.REZERVASYONLAR (GIRIS_TARIHI,CIKIS_TARIHI,ODA_ID,MUSTERI_ID,REZERVASYON_ID) values ('2019-12-21','2019-12-22','11','6','21');
REM INSERTING into GAZI1.SEHIRLER
SET DEFINE OFF;
Insert into GAZI1.SEHIRLER (SEHIR_ID,SEHIR_ADI) values ('3','ÝSTANBUL');
Insert into GAZI1.SEHIRLER (SEHIR_ID,SEHIR_ADI) values ('1','SAMSUN');
Insert into GAZI1.SEHIRLER (SEHIR_ID,SEHIR_ADI) values ('2','ANKARA');
Insert into GAZI1.SEHIRLER (SEHIR_ID,SEHIR_ADI) values ('4','ÝZMÝR');
REM INSERTING into GAZI1.YONETICI
SET DEFINE OFF;
Insert into GAZI1.YONETICI (YONETICI_ADI,PAROLA) values ('admin','admin');
--------------------------------------------------------
--  DDL for Index OTELLER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GAZI1"."OTELLER_PK" ON "GAZI1"."OTELLER" ("OTEL_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index REZERVASYONLAR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GAZI1"."REZERVASYONLAR_PK" ON "GAZI1"."REZERVASYONLAR" ("REZERVASYON_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ODALAR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GAZI1"."ODALAR_PK" ON "GAZI1"."ODALAR" ("ODA_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MUSTERILER_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "GAZI1"."MUSTERILER_UK1" ON "GAZI1"."MUSTERILER" ("KIMLIK") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SEHIRLER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GAZI1"."SEHIRLER_PK" ON "GAZI1"."SEHIRLER" ("SEHIR_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MUSTERILER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GAZI1"."MUSTERILER_PK" ON "GAZI1"."MUSTERILER" ("MUSTERI_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SEHIRLER
--------------------------------------------------------

  ALTER TABLE "GAZI1"."SEHIRLER" ADD CONSTRAINT "SEHIRLER_PK" PRIMARY KEY ("SEHIR_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "GAZI1"."SEHIRLER" MODIFY ("SEHIR_ID" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."SEHIRLER" MODIFY ("SEHIR_ADI" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table OTELLER
--------------------------------------------------------

  ALTER TABLE "GAZI1"."OTELLER" ADD CONSTRAINT "OTELLER_PK" PRIMARY KEY ("OTEL_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "GAZI1"."OTELLER" MODIFY ("OTEL_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MUSTERILER
--------------------------------------------------------

  ALTER TABLE "GAZI1"."MUSTERILER" MODIFY ("MUSTERI_ID" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."MUSTERILER" ADD CONSTRAINT "MUSTERILER_UK1" UNIQUE ("KIMLIK")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "GAZI1"."MUSTERILER" MODIFY ("PAROLA" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."MUSTERILER" MODIFY ("KIMLIK" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."MUSTERILER" MODIFY ("TELEFON" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."MUSTERILER" MODIFY ("SOYAD" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."MUSTERILER" MODIFY ("AD" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."MUSTERILER" ADD CONSTRAINT "MUSTERILER_PK" PRIMARY KEY ("MUSTERI_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REZERVASYONLAR
--------------------------------------------------------

  ALTER TABLE "GAZI1"."REZERVASYONLAR" ADD CONSTRAINT "REZERVASYONLAR_PK" PRIMARY KEY ("REZERVASYON_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "GAZI1"."REZERVASYONLAR" MODIFY ("REZERVASYON_ID" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."REZERVASYONLAR" MODIFY ("MUSTERI_ID" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."REZERVASYONLAR" MODIFY ("CIKIS_TARIHI" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."REZERVASYONLAR" MODIFY ("GIRIS_TARIHI" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."REZERVASYONLAR" MODIFY ("ODA_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ODALAR
--------------------------------------------------------

  ALTER TABLE "GAZI1"."ODALAR" MODIFY ("FIYAT" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ODALAR" ADD CONSTRAINT "ODALAR_PK" PRIMARY KEY ("ODA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "GAZI1"."ODALAR" MODIFY ("OTEL_ID" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ODALAR" MODIFY ("ODA_TIPI" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ODALAR" MODIFY ("ODA_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table YONETICI
--------------------------------------------------------

  ALTER TABLE "GAZI1"."YONETICI" MODIFY ("PAROLA" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."YONETICI" MODIFY ("YONETICI_ADI" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ODALAR
--------------------------------------------------------

  ALTER TABLE "GAZI1"."ODALAR" ADD CONSTRAINT "ODALAR_OTELLER_FK1" FOREIGN KEY ("OTEL_ID")
	  REFERENCES "GAZI1"."OTELLER" ("OTEL_ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OTELLER
--------------------------------------------------------

  ALTER TABLE "GAZI1"."OTELLER" ADD CONSTRAINT "OTELLER_SEHIRLER_FK1" FOREIGN KEY ("SEHIR_ID")
	  REFERENCES "GAZI1"."SEHIRLER" ("SEHIR_ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REZERVASYONLAR
--------------------------------------------------------

  ALTER TABLE "GAZI1"."REZERVASYONLAR" ADD CONSTRAINT "REZERVASYONLAR_MUSTERILER_FK1" FOREIGN KEY ("MUSTERI_ID")
	  REFERENCES "GAZI1"."MUSTERILER" ("MUSTERI_ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "GAZI1"."REZERVASYONLAR" ADD CONSTRAINT "REZERVASYONLAR_ODALAR_FK1" FOREIGN KEY ("ODA_ID")
	  REFERENCES "GAZI1"."ODALAR" ("ODA_ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  DDL for Trigger MUSTERI_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GAZI1"."MUSTERI_TRG" 
BEFORE INSERT ON MUSTERILER 
FOR EACH ROW 
BEGIN
  select musterý_seq.NEXTVAL INTO:NEW.musterý_ýd FROM DUAL;
END;
/
ALTER TRIGGER "GAZI1"."MUSTERI_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ODALAR_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GAZI1"."ODALAR_TRG" 
BEFORE INSERT ON ODALAR 
FOR EACH ROW 
BEGIN
 select odalar_seq.NEXTVAL INTO:NEW.oda_ýd FROM DUAL;
END;
/
ALTER TRIGGER "GAZI1"."ODALAR_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger OTELLER_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GAZI1"."OTELLER_TRG" 
BEFORE INSERT ON OTELLER 
FOR EACH ROW 
BEGIN
 select oteller_seq.NEXTVAL INTO:NEW.otel_ýd FROM DUAL;
END;
/
ALTER TRIGGER "GAZI1"."OTELLER_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SEHIR_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GAZI1"."SEHIR_TRG" 
BEFORE INSERT ON SEHIRLER 
FOR EACH ROW 
BEGIN
  select seq_sehýr.NEXTVAL INTO:NEW.sehir_ýd FROM DUAL;
END;
/
ALTER TRIGGER "GAZI1"."SEHIR_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "GAZI1"."CUSTOM_AUTH" (p_username in VARCHAR2, p_password in VARCHAR2)
return BOOLEAN
is
  l_password varchar2(4000);
  l_stored_password varchar2(4000);
  l_expires_on date;
  l_count number;
begin
-- First, check to see if the user is in the user table
select count(*) into l_count from demo_users where user_name = p_username;
if l_count > 0 then
  -- First, we fetch the stored hashed password & expire date
  select password, expires_on into l_stored_password, l_expires_on
   from demo_users where user_name = p_username;

  -- Next, we check to see if the user's account is expired
  -- If it is, return FALSE
  if l_expires_on > sysdate or l_expires_on is null then

    -- If the account is not expired, we have to apply the custom hash
    -- function to the password
    l_password := custom_hash(p_username, p_password);

    -- Finally, we compare them to see if they are the same and return
    -- either TRUE or FALSE
    if l_password = l_stored_password then
      return true;
    else
      return false;
    end if;
  else
    return false;
  end if;
else
  -- The username provided is not in the DEMO_USERS table
  return false;
end if;
end;

/
--------------------------------------------------------
--  DDL for Function CUSTOM_HASH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "GAZI1"."CUSTOM_HASH" (p_username in varchar2, p_password in varchar2)
return varchar2
is
  l_password varchar2(4000);
  l_salt varchar2(4000) := 'C0AJCJ7R0WFXQEE3YVRDC66GLX8L7Z';
begin

-- This function should be wrapped, as the hash algorhythm is exposed here.
-- You can change the value of l_salt or the method of which to call the
-- DBMS_OBFUSCATOIN toolkit, but you much reset all of your passwords
-- if you choose to do this.

l_password := utl_raw.cast_to_raw(dbms_obfuscation_toolkit.md5
  (input_string => p_password || substr(l_salt,10,13) || p_username ||
    substr(l_salt, 4,10)));
return l_password;
end;

/
--------------------------------------------------------
--  DDL for Procedure PR_ODAEKLE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "GAZI1"."PR_ODAEKLE" (p_odaTipi IN VARCHAR,p_fiyat IN NUMBER,p_otelid IN NUMBER)
AS
BEGIN
   INSERT INTO odalar(oda_tipi,otel_id,fiyat)
        VALUES(p_odaTipi,p_otelid,p_fiyat);
END pr_odaEkle;

/
--------------------------------------------------------
--  DDL for Procedure PR_REZERVASYON
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "GAZI1"."PR_REZERVASYON" (p_giris_tarihi IN VARCHAR,p_cikis_tarihi IN VARCHAR,p_oda_id IN NUMBER,p_musteri_id IN NUMBER)
AS
BEGIN
   INSERT INTO rezervasyonlar(giris_tarihi,cikis_tarihi,oda_id,musteri_id,rezervasyon_id)
        VALUES(p_giris_tarihi,p_cikis_tarihi,p_oda_id,p_musteri_id,rezervasyon_seq.NextVal);
END pr_rezervasyon;

/
