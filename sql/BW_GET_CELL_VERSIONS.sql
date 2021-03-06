SELECT  
	BW_CELL.ID   CELL_ID, 
	BW_CELL.CELL_TYPE   CELL_TYPE,
	BW_SV.STRING_VALUE   CELL_STRING_VALUE, 
	1 CELL_INTEGER_VALUE,
	1.1 CELL_DOUBLE_VALUE, 
	-1 CELL_TBL_VALUE,
	BW_TRANS.TX_ID   TRANSACTION_ID,
	BW_TRANS.CREATED_ON,
	BW_TRANS.CREATED_BY,
	BW_TRANS.DESCRIPTION,
	BW_TRANS.COMMENT_,
	BW_USER.EMAIL_ADDRESS,
	BW_CELL.BW_ROW_ID   ROW_ID,
	BW_CELL.BW_ROW_ID   COLUMN_ID,
	BWCOLUMN.NAME   COLUMN_NAME,
	BWTABLE.NAME   TABLE_NAME
FROM    BW_CELL,
	BW_STRING_VALUE   BW_SV, 
	BW_TXS    BW_TRANS,
	BW_USER   BW_USER,
	BW_COLUMN    BWCOLUMN,
	BW_TBL   BWTABLE
WHERE	
	BW_CELL.ID = ?
	AND BWCOLUMN.ID = BW_CELL.BW_COLUMN_ID
	AND BWTABLE.ID = BWCOLUMN.BW_TBL_ID
	AND BW_CELL.ID =  BW_SV.BW_CELL_ID  
	AND BW_USER.ID = BW_TRANS.CREATED_BY
	AND BW_TRANS.TX_ID = BW_SV.TX_ID 	
	AND BW_SV.STRING_VALUE LIKE ?
	AND BW_TRANS.CREATED_ON >= ?
	AND BW_TRANS.CREATED_ON <= ?

UNION ALL
SELECT  
	BW_CELL.ID   CELL_ID, 
	BW_CELL.CELL_TYPE   CELL_TYPE,
	' ' CELL_STRING_VALUE, 
	BW_IV.INTEGER_VALUE   CELL_INTEGER_VALUE,
	1.1 CELL_DOUBLE_VALUE, 
	-1 CELL_TBL_VALUE,
	BW_TRANS.TX_ID   TRANSACTION_ID,
	BW_TRANS.CREATED_ON,
	BW_TRANS.CREATED_BY,
	BW_TRANS.DESCRIPTION,
	BW_TRANS.COMMENT_,
	BW_USER.EMAIL_ADDRESS,
	BW_CELL.BW_ROW_ID   ROW_ID,
	BW_CELL.BW_ROW_ID   COLUMN_ID,
	BWCOLUMN.NAME   COLUMN_NAME,
	BWTABLE.NAME   TABLE_NAME
FROM    BW_CELL,
	BW_INTEGER_VALUE   BW_IV, 
	
	BW_TXS    BW_TRANS,
	BW_USER   BW_USER,
	BW_COLUMN    BWCOLUMN,
	BW_TBL   BWTABLE
WHERE	
	BW_CELL.ID = ?
	AND BWCOLUMN.ID = BW_CELL.BW_COLUMN_ID
	AND BWTABLE.ID = BWCOLUMN.BW_TBL_ID
	AND BW_USER.ID = BW_TRANS.CREATED_BY
	AND BW_CELL.ID =  BW_IV.BW_CELL_ID  
	AND BW_TRANS.TX_ID = BW_IV.TX_ID 	
	AND BW_IV.INTEGER_VALUE LIKE ?
	AND BW_TRANS.CREATED_ON >= ?
	AND BW_TRANS.CREATED_ON <= ?
UNION all
SELECT  
	BW_CELL.ID   CELL_ID, 
	BW_CELL.CELL_TYPE   CELL_TYPE,
	' ' CELL_STRING_VALUE, 
	1 CELL_INTEGER_VALUE,
	BW_DV.DOUBLE_VALUE   CELL_DOUBLE_VALUE,
	-1 CELL_TBL_VALUE,
	BW_TRANS.TX_ID   TRANSACTION_ID,
	BW_TRANS.CREATED_ON,
	BW_TRANS.CREATED_BY,
	BW_TRANS.DESCRIPTION,
	BW_TRANS.COMMENT_,
	BW_USER.EMAIL_ADDRESS,
	BW_CELL.BW_ROW_ID   ROW_ID,
	BW_CELL.BW_ROW_ID   COLUMN_ID,
	BWCOLUMN.NAME   COLUMN_NAME,
	BWTABLE.NAME   TABLE_NAME
FROM    BW_CELL,
	
	BW_DOUBLE_VALUE    BW_DV,
	BW_TXS    BW_TRANS,
	BW_USER   BW_USER,
	BW_COLUMN    BWCOLUMN,
	BW_TBL   BWTABLE
WHERE	
	BW_CELL.ID = ?
	AND BWCOLUMN.ID = BW_CELL.BW_COLUMN_ID
	AND BWTABLE.ID = BWCOLUMN.BW_TBL_ID
	AND BW_USER.ID = BW_TRANS.CREATED_BY
	AND BW_CELL.ID =  BW_DV.BW_CELL_ID  
	AND BW_TRANS.TX_ID = BW_DV.TX_ID 	
	AND BW_DV.DOUBLE_VALUE LIKE ?
	AND BW_TRANS.CREATED_ON >= ?
	AND BW_TRANS.CREATED_ON <= ?
ORDER BY TRANSACTION_ID