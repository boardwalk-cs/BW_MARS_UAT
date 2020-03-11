SELECT 	BWROW.NAME   ROW_NAME, 
	BWROW.ID   ROW_ID, 
	BWROW.SEQUENCE_NUMBER   ROW_SEQUENCE_NUMBER, 
	BWCOLUMN.ID   COLUMN_ID,  
	BWCOLUMN.SEQUENCE_NUMBER   COLUMN_SEQUENCE_NUMBER, 
	BWCOLUMN.NAME   COLUMN_NAME,  
	BWCELL.ID   CELL_ID, 
	BWCELL.CELL_TYPE   CELL_TYPE, 
	BWCELL.STRING_VALUE   CELL_STRING_VALUE, 
	BWCELL.INTEGER_VALUE   CELL_INTEGER_VALUE, 
	BWCELL.DOUBLE_VALUE   CELL_DOUBLE_VALUE, 
	BWCELL.TABLE_VALUE   CELL_TBL_VALUE, 
	' ' CELL_TBL_NAME, 
	BW_TXS.TX_ID, 
	BW_TXS.CREATED_BY   TX_CREATED_BY,
	BW_TXS.CREATED_ON,
	BW_TXS.DESCRIPTION,
	BW_TXS.COMMENT_,
	BW_USER.EMAIL_ADDRESS, 
	BWROW.OWNER_ID, 
	BWROW.IS_ACTIVE,
	BWROW.TX_ID   ROW_TID, 
	BWCOLUMN.TX_ID   COL_TID, 
	BWCOLUMN.IS_ACTIVE   COL_ACTIVE,
	BWROW.OWNER_TID   ROW_OWNER_TID,
	BW_ROW_CREATOR_TX.CREATED_BY   ROW_CREATOR_ID,  
	BW_ROW_OWNER.EMAIL_ADDRESS   ROW_OWNER_NAME,
	BWCELL.FORMULA
FROM    BW_ROW   BWROW, 
	BW_COLUMN   BWCOLUMN, 
	BW_CELL   BWCELL,
	BW_TXS, 
	BW_USER,
	BW_TXS   BW_ROW_CREATOR_TX,	
	BW_USER   BW_ROW_OWNER
WHERE	
		BWCOLUMN.BW_TBL_ID = ?	
	AND	BWCELL.BW_COLUMN_ID = BWCOLUMN.ID	
	AND  	BWCELL.BW_ROW_ID = BWROW.ID
	AND  	BWROW.BW_TBL_ID = ?	
	AND     BWCELL.TX_ID = BW_TXS.TX_ID
	AND     BW_TXS.CREATED_BY = BW_USER.ID
	AND     BWROW.IS_ACTIVE = 1
	AND   	BW_ROW_CREATOR_TX.TX_ID = BWROW.TX_ID
	AND     BW_ROW_OWNER.ID = BWROW.OWNER_ID
ORDER BY  ROW_SEQUENCE_NUMBER, COLUMN_SEQUENCE_NUMBER