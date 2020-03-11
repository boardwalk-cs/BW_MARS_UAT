SELECT 	
	BW_ROW.NAME   ROW_NAME, 
	BW_ROW.ID   ROW_ID, 
	BW_ROW.SEQUENCE_NUMBER   ROW_SEQUENCE_NUMBER,
	BW_COLUMN.ID   COLUMN_ID, 
	BW_COLUMN.SEQUENCE_NUMBER COLUMN_SEQUENCE_NUMBER,  
	BW_COLUMN.NAME   COLUMN_NAME,  
	BW_CELL_BY_USER.CELL_ID,
	BW_CELL.CELL_TYPE,
	BW_STRING_VALUE.STRING_VALUE   CELL_STRING_VALUE,
	-1 CELL_INTEGER_VALUE,
	1.1 CELL_DOUBLE_VALUE,
	-1 CELL_TBL_VALUE,
	'Not Set' CELL_TBL_NAME, 
	BW_TXS.TX_ID, BW_TXS.CREATED_BY   TX_CREATED_BY, 
	BW_TXS.CREATED_ON,
	BW_TXS.DESCRIPTION,
	BW_TXS.COMMENT_,
	BW_USER.EMAIL_ADDRESS,  
	BW_ROW.OWNER_ID, 
	BW_ROW.IS_ACTIVE,
	BW_ROW.TX_ID   ROW_TID, 
	BW_COLUMN.TX_ID   COL_TID, 
	BW_COLUMN.IS_ACTIVE   COL_ACTIVE,
	BW_ROW.OWNER_TID   ROW_OWNER_TID,
	BW_ROW_CREATOR_TX.CREATED_BY   ROW_CREATOR_ID,  
	BW_ROW_OWNER.EMAIL_ADDRESS   ROW_OWNER_NAME
FROM  	(SELECT BW_CELL.ID   CELL_ID,  MAX(BW_STRING_VALUE.TX_ID)   TXID
	FROM BW_ROW, BW_CELL, BW_STRING_VALUE, BW_TXS
	WHERE
			BW_ROW.BW_TBL_ID = ?
		AND     BW_CELL.CELL_TYPE = 'STRING'					
		AND 	BW_TXS.CREATED_BY = ?						        
		AND 	BW_CELL.BW_ROW_ID = BW_ROW.ID
		AND     BW_CELL.ID = BW_STRING_VALUE.BW_CELL_ID
		AND     BW_STRING_VALUE.TX_ID = BW_TXS.TX_ID
		AND      BW_ROW.IS_ACTIVE = 1				
	GROUP BY BW_CELL.ID
	)   BW_CELL_BY_USER,
	BW_STRING_VALUE,
	BW_ROW, 
	BW_CELL,
	BW_COLUMN,
	BW_TXS,
	BW_USER,
	BW_TXS   BW_ROW_CREATOR_TX,	
	BW_USER   BW_ROW_OWNER
WHERE 	BW_STRING_VALUE.TX_ID = BW_CELL_BY_USER.TXID
	AND  BW_STRING_VALUE.BW_CELL_ID = BW_CELL_BY_USER.CELL_ID
	AND  BW_CELL.ID = BW_STRING_VALUE.BW_CELL_ID
	AND  BW_CELL.BW_ROW_ID = BW_ROW.ID
	AND  BW_CELL.BW_COLUMN_ID = BW_COLUMN.ID
	AND  BW_TXS.TX_ID = BW_CELL_BY_USER.TXID
	AND  BW_TXS.CREATED_BY = BW_USER.ID
	AND  BW_USER.ID = ?
	AND  BW_ROW.IS_ACTIVE = 1
	AND  BW_ROW_CREATOR_TX.TX_ID = BW_ROW.TX_ID
	AND  BW_ROW_OWNER.ID = BW_ROW.OWNER_ID
union ALL
SELECT 	BW_ROW.NAME   ROW_NAME, 
	BW_ROW.ID   ROW_ID, 
	BW_ROW.SEQUENCE_NUMBER   ROW_SEQUENCE_NUMBER,
	BW_COLUMN.ID   COLUMN_ID, 
	BW_COLUMN.SEQUENCE_NUMBER COLUMN_SEQUENCE_NUMBER,  
	BW_COLUMN.NAME   COLUMN_NAME,  
	BW_CELL_BY_USER.CELL_ID,
	BW_CELL.CELL_TYPE,
	'_' CELL_STRING_VALUE,
	BW_INTEGER_VALUE.INTEGER_VALUE   CELL_INTEGER_VALUE,
	1.1 CELL_DOUBLE_VALUE,
	-1 CELL_TBL_VALUE,
	'Not Set' CELL_TBL_NAME, BW_TXS.TX_ID, BW_TXS.CREATED_BY   TX_CREATED_BY, BW_TXS.CREATED_ON,
 	BW_TXS.DESCRIPTION,
	BW_TXS.COMMENT_,
	BW_USER.EMAIL_ADDRESS, BW_ROW.OWNER_ID, BW_ROW.IS_ACTIVE,BW_ROW.TX_ID   ROW_TID, BW_COLUMN.TX_ID   COL_TID, BW_COLUMN.IS_ACTIVE   COL_ACTIVE,BW_ROW.OWNER_TID   ROW_OWNER_TID,BW_ROW_CREATOR_TX.CREATED_BY   ROW_CREATOR_ID,  BW_ROW_OWNER.EMAIL_ADDRESS   ROW_OWNER_NAME
FROM 
	(SELECT BW_CELL.ID   CELL_ID,  MAX(BW_INTEGER_VALUE.TX_ID)   TXID
	FROM BW_ROW, BW_CELL, BW_INTEGER_VALUE, BW_TXS
	WHERE	BW_ROW.BW_TBL_ID = ?
		AND     BW_CELL.CELL_TYPE = 'INTEGER'					
		AND 	BW_TXS.CREATED_BY = ?						        
		AND 	BW_CELL.BW_ROW_ID = BW_ROW.ID
		AND     BW_CELL.ID = BW_INTEGER_VALUE.BW_CELL_ID
		AND     BW_INTEGER_VALUE.TX_ID = BW_TXS.TX_ID
		AND      BW_ROW.IS_ACTIVE = 1				
	GROUP BY BW_CELL.ID
	)   BW_CELL_BY_USER,
	BW_INTEGER_VALUE,
	BW_ROW, 
	BW_CELL,
	BW_COLUMN,
	BW_TXS, 
	BW_USER,
	BW_TXS   BW_ROW_CREATOR_TX,	
	BW_USER   BW_ROW_OWNER
WHERE 	BW_INTEGER_VALUE.TX_ID = BW_CELL_BY_USER.TXID
	AND  BW_INTEGER_VALUE.BW_CELL_ID = BW_CELL_BY_USER.CELL_ID
	AND  BW_CELL.ID = BW_INTEGER_VALUE.BW_CELL_ID
	AND  BW_CELL.BW_ROW_ID = BW_ROW.ID
	AND  BW_CELL.BW_COLUMN_ID = BW_COLUMN.ID
	AND   BW_TXS.TX_ID = BW_CELL_BY_USER.TXID
	AND   BW_TXS.CREATED_BY = BW_USER.ID
	AND   BW_USER.ID = ?
	AND      BW_ROW.IS_ACTIVE = 1
	AND   	BW_ROW_CREATOR_TX.TX_ID = BW_ROW.TX_ID
	AND     BW_ROW_OWNER.ID = BW_ROW.OWNER_ID
union ALL
SELECT 	BW_ROW.NAME   ROW_NAME, 
	BW_ROW.ID   ROW_ID, 
	BW_ROW.SEQUENCE_NUMBER   ROW_SEQUENCE_NUMBER,
	BW_COLUMN.ID   COLUMN_ID, 
	BW_COLUMN.SEQUENCE_NUMBER COLUMN_SEQUENCE_NUMBER,  
	BW_COLUMN.NAME   COLUMN_NAME,  
	BW_CELL_BY_USER.CELL_ID,
	BW_CELL.CELL_TYPE, 
	'_' CELL_STRING_VALUE,
	-1 CELL_INTEGER_VALUE,	
	BW_DOUBLE_VALUE.DOUBLE_VALUE   CELL_DOUBLE_VALUE,
	-1 CELL_TBL_VALUE,
	'Not Set' CELL_TBL_NAME, BW_TXS.TX_ID, BW_TXS.CREATED_BY   TX_CREATED_BY, BW_TXS.CREATED_ON,
	BW_TXS.DESCRIPTION,
	BW_TXS.COMMENT_,
	BW_USER.EMAIL_ADDRESS, BW_ROW.OWNER_ID, BW_ROW.IS_ACTIVE,BW_ROW.TX_ID   ROW_TID, BW_COLUMN.TX_ID   COL_TID, BW_COLUMN.IS_ACTIVE   COL_ACTIVE,BW_ROW.OWNER_TID   ROW_OWNER_TID,BW_ROW_CREATOR_TX.CREATED_BY   ROW_CREATOR_ID,  BW_ROW_OWNER.EMAIL_ADDRESS   ROW_OWNER_NAME
FROM (	SELECT BW_CELL.ID   CELL_ID,  MAX(BW_DOUBLE_VALUE.TX_ID)   TXID
	FROM BW_ROW, BW_CELL, BW_DOUBLE_VALUE, BW_TXS
	WHERE
			BW_ROW.BW_TBL_ID =?
		AND     BW_CELL.CELL_TYPE = 'FLOAT'					
		AND 	BW_TXS.CREATED_BY = ?						        
		AND 	BW_CELL.BW_ROW_ID = BW_ROW.ID
		AND     BW_CELL.ID = BW_DOUBLE_VALUE.BW_CELL_ID
		AND     BW_DOUBLE_VALUE.TX_ID = BW_TXS.TX_ID
		AND      BW_ROW.IS_ACTIVE = 1				
	GROUP BY BW_CELL.ID
	)   BW_CELL_BY_USER,
	BW_DOUBLE_VALUE,BW_ROW, 
	BW_CELL,BW_COLUMN,
	BW_TXS,
	BW_USER,
	BW_TXS   BW_ROW_CREATOR_TX,	
	BW_USER   BW_ROW_OWNER
WHERE 	BW_DOUBLE_VALUE.TX_ID = BW_CELL_BY_USER.TXID
	AND  BW_DOUBLE_VALUE.BW_CELL_ID = BW_CELL_BY_USER.CELL_ID
	AND  BW_CELL.ID = BW_DOUBLE_VALUE.BW_CELL_ID
	AND  BW_CELL.BW_ROW_ID = BW_ROW.ID
	AND  BW_CELL.BW_COLUMN_ID = BW_COLUMN.ID	
	AND  BW_TXS.TX_ID = BW_CELL_BY_USER.TXID
	AND  BW_TXS.CREATED_BY = BW_USER.ID
	AND  BW_USER.ID = ?
	AND  BW_ROW.IS_ACTIVE = 1
	AND  BW_ROW_CREATOR_TX.TX_ID = BW_ROW.TX_ID
	AND  BW_ROW_OWNER.ID = BW_ROW.OWNER_ID
UNION ALL
SELECT 	 BW_ROW.NAME   ROW_NAME, 
	BW_ROW.ID   ROW_ID, 
	BW_ROW.SEQUENCE_NUMBER   ROW_SEQUENCE_NUMBER,
	BW_COLUMN.ID   COLUMN_ID, 
	BW_COLUMN.SEQUENCE_NUMBER COLUMN_SEQUENCE_NUMBER,  
	BW_COLUMN.NAME   COLUMN_NAME,  
	BW_CELL.ID   CELL_ID,
	BW_CELL.CELL_TYPE,
	BW_CELL.DESIGN_STRING_VALUE   CELL_STRING_VALUE,
	BW_CELL.DESIGN_INTEGER_VALUE   CELL_INTEGER_VALUE,
	BW_CELL.DESIGN_DOUBLE_VALUE   CELL_DOUBLE_VALUE ,
	BW_CELL.DESIGN_TBL_VALUE   CELL_TBL_VALUE,
	'Not Set' CELL_TBL_NAME, 
	BW_TXS.TX_ID, 
	BW_TXS.CREATED_BY   TX_CREATED_BY, 
	BW_TXS.CREATED_ON,
	BW_TXS.DESCRIPTION,
	BW_TXS.COMMENT_,
	BW_USER.EMAIL_ADDRESS, 
	BW_ROW.OWNER_ID,
	BW_ROW.IS_ACTIVE,BW_ROW.TX_ID   ROW_TID,
	BW_COLUMN.TX_ID   COL_TID, 
	BW_COLUMN.IS_ACTIVE   COL_ACTIVE,
	BW_ROW.OWNER_TID   ROW_OWNER_TID,
	BW_ROW_CREATOR_TX.CREATED_BY   ROW_CREATOR_ID,  
	BW_ROW_OWNER.EMAIL_ADDRESS   ROW_OWNER_NAME
FROM 	BW_ROW,
	BW_CELL,
	BW_COLUMN,
	BW_TXS, 
	BW_USER	,
	BW_TXS   
	BW_ROW_CREATOR_TX,	
	BW_USER   BW_ROW_OWNER
WHERE 	  
	 BW_CELL.BW_ROW_ID = BW_ROW.ID
	 AND  BW_CELL.BW_COLUMN_ID = BW_COLUMN.ID
	 AND  BW_ROW.BW_TBL_ID = ?
	 AND  BW_CELL.ID  NOT IN 
	 (SELECT BW_CELL.ID   CELL_ID
		FROM BW_ROW, BW_CELL, BW_STRING_VALUE, BW_TXS
		WHERE
			BW_ROW.BW_TBL_ID = ?
		AND     BW_CELL.CELL_TYPE = 'STRING'					
		AND 	BW_CELL.BW_ROW_ID = BW_ROW.ID
		AND     BW_CELL.ID = BW_STRING_VALUE.BW_CELL_ID
		AND     BW_STRING_VALUE.TX_ID = BW_TXS.TX_ID	
		AND BW_TXS.CREATED_BY = ?
		AND      BW_ROW.IS_ACTIVE = 1
		GROUP BY BW_CELL.ID
	 )
	AND  BW_TXS.TX_ID = BW_COLUMN.TX_ID
 	AND  BW_TXS.CREATED_BY = BW_USER.ID
	AND  BW_ROW.IS_ACTIVE = 1
	AND  BW_ROW_CREATOR_TX.TX_ID = BW_ROW.TX_ID
	AND  BW_ROW_OWNER.ID = BW_ROW.OWNER_ID
union ALL
SELECT BW_ROW.NAME   ROW_NAME, 
	BW_ROW.ID   ROW_ID, 
	BW_ROW.SEQUENCE_NUMBER   ROW_SEQUENCE_NUMBER,
	BW_COLUMN.ID   COLUMN_ID, 
	BW_COLUMN.SEQUENCE_NUMBER COLUMN_SEQUENCE_NUMBER,  
	BW_COLUMN.NAME   COLUMN_NAME,  
	BW_CELL.ID   CELL_ID,
	BW_CELL.CELL_TYPE,
	BW_COLUMN.DEFAULT_STRING_VALUE   CELL_STRING_VALUE,
	BW_COLUMN.DEFAULT_INTEGER_VALUE   CELL_INTEGER_VALUE,
	BW_COLUMN.DEFAULT_FLOAT_VALUE   CELL_DOUBLE_VALUE ,
	BW_COLUMN.DEAFULT_TBL_VALUE   CELL_TBL_VALUE,
	'Not Set' CELL_TBL_NAME, BW_TXS.TX_ID, BW_TXS.CREATED_BY   TX_CREATED_BY, BW_TXS.CREATED_ON,
	BW_TXS.DESCRIPTION,
	BW_TXS.COMMENT_,
	BW_USER.EMAIL_ADDRESS, BW_ROW.OWNER_ID, BW_ROW.IS_ACTIVE,BW_ROW.TX_ID   ROW_TID, BW_COLUMN.TX_ID   COL_TID, BW_COLUMN.IS_ACTIVE   COL_ACTIVE,BW_ROW.OWNER_TID   ROW_OWNER_TID,BW_ROW_CREATOR_TX.CREATED_BY   ROW_CREATOR_ID,  BW_ROW_OWNER.EMAIL_ADDRESS   ROW_OWNER_NAME
FROM BW_ROW,BW_CELL,BW_COLUMN,BW_TXS, BW_USER,BW_TXS   BW_ROW_CREATOR_TX,	
		BW_USER   BW_ROW_OWNER
WHERE 	     BW_CELL.BW_ROW_ID = BW_ROW.ID
	 AND  BW_CELL.BW_COLUMN_ID = BW_COLUMN.ID
	 AND  BW_ROW.BW_TBL_ID = ?
	 AND  BW_CELL.ID  NOT IN 
	 (
		SELECT BW_CELL.ID   CELL_ID
		FROM BW_ROW, BW_CELL, BW_INTEGER_VALUE, BW_TXS
		WHERE
			   	BW_ROW.BW_TBL_ID = ?
			AND     BW_CELL.CELL_TYPE = 'INTEGER'					
			AND 	BW_CELL.BW_ROW_ID = BW_ROW.ID
			AND     BW_CELL.ID = BW_INTEGER_VALUE.BW_CELL_ID
			AND     BW_INTEGER_VALUE.TX_ID = BW_TXS.TX_ID	
			AND BW_TXS.CREATED_BY = ?
			AND      BW_ROW.IS_ACTIVE = 1	
		GROUP BY BW_CELL.ID
	 )
	AND BW_TXS.TX_ID = BW_COLUMN.TX_ID
	AND BW_TXS.CREATED_BY = BW_USER.ID
	AND      BW_ROW.IS_ACTIVE = 1
AND   	BW_ROW_CREATOR_TX.TX_ID = BW_ROW.TX_ID
	AND     BW_ROW_OWNER.ID = BW_ROW.OWNER_ID
UNION ALL
SELECT 	  BW_ROW.NAME   ROW_NAME, 
	BW_ROW.ID   ROW_ID, 
	BW_ROW.SEQUENCE_NUMBER   ROW_SEQUENCE_NUMBER,
	BW_COLUMN.ID   COLUMN_ID, 
	BW_COLUMN.SEQUENCE_NUMBER COLUMN_SEQUENCE_NUMBER,  
	BW_COLUMN.NAME   COLUMN_NAME,  
	BW_CELL.ID   CELL_ID,
	BW_CELL.CELL_TYPE,
	BW_COLUMN.DEFAULT_STRING_VALUE   CELL_STRING_VALUE,
	BW_COLUMN.DEFAULT_INTEGER_VALUE   CELL_INTEGER_VALUE,
	BW_COLUMN.DEFAULT_FLOAT_VALUE   CELL_DOUBLE_VALUE ,
	BW_COLUMN.DEAFULT_TBL_VALUE   CELL_TBL_VALUE,
	'Not Set' CELL_TBL_NAME, BW_TXS.TX_ID, BW_TXS.CREATED_BY   TX_CREATED_BY, BW_TXS.CREATED_ON,
	BW_TXS.DESCRIPTION,
	BW_TXS.COMMENT_,
	BW_USER.EMAIL_ADDRESS, BW_ROW.OWNER_ID, BW_ROW.IS_ACTIVE,BW_ROW.TX_ID   ROW_TID, BW_COLUMN.TX_ID   COL_TID, BW_COLUMN.IS_ACTIVE   COL_ACTIVE,BW_ROW.OWNER_TID   ROW_OWNER_TID,BW_ROW_CREATOR_TX.CREATED_BY   ROW_CREATOR_ID,  BW_ROW_OWNER.EMAIL_ADDRESS   ROW_OWNER_NAME
FROM BW_ROW,BW_CELL,BW_COLUMN	,BW_TXS, BW_USER,BW_TXS   BW_ROW_CREATOR_TX,	
		BW_USER   BW_ROW_OWNER	
WHERE 	  BW_CELL.BW_ROW_ID = BW_ROW.ID
	 AND  BW_CELL.BW_COLUMN_ID = BW_COLUMN.ID
	 AND  BW_ROW.BW_TBL_ID = ?
	 AND  BW_CELL.ID  NOT IN 
	 (
		SELECT BW_CELL.ID   CELL_ID
		FROM BW_ROW, BW_CELL, BW_DOUBLE_VALUE, BW_TXS
		WHERE
			   	BW_ROW.BW_TBL_ID = ?
			AND     BW_CELL.CELL_TYPE = 'FLOAT'					
			AND 	BW_CELL.BW_ROW_ID = BW_ROW.ID
			AND     BW_CELL.ID = BW_DOUBLE_VALUE.BW_CELL_ID
			AND     BW_DOUBLE_VALUE.TX_ID = BW_TXS.TX_ID	
			AND BW_TXS.CREATED_BY = ?
			AND      BW_ROW.IS_ACTIVE = 1			
		GROUP BY BW_CELL.ID
	 )	
	AND BW_TXS.TX_ID = BW_COLUMN.TX_ID
	AND BW_TXS.CREATED_BY = BW_USER.ID
	AND      BW_ROW.IS_ACTIVE = 1
	AND   	BW_ROW_CREATOR_TX.TX_ID = BW_ROW.TX_ID
	AND     BW_ROW_OWNER.ID = BW_ROW.OWNER_ID