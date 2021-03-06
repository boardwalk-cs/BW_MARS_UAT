SELECT 
	COLLAB.ID , COLLAB.NAME, COLLAB.PURPOSE, 
	COLLAB_NH.NAME   COLLAB_NH_NAME, 
	WHITEBOARD.NAME   WB_NAME, 
	WHITEBOARD.ID   WB_ID,                
	BWTABLE.ID   BW_TBL_ID, 
	BWTABLE.NEIGHBORHOOD_ID   NEIGHBORHOOD_ID, 
	BWTABLE.NAME BW_TBL_NAME, 
	BWTABLE.PURPOSE   BW_TBL_PURPOSE, 
	BWTABLE.VIEW_PREFERENCE_TYPE,
	BWTABLE.IS_LOCKED,
	BWTABLE.LOCK_TX_ID,
	BWUSER.ID   LOCKED_BY_ID,
	BWUSER.EMAIL_ADDRESS   LOCKED_BY,
	BW_TXS.CREATED_ON LOCK_UNLOCK_TIME	
FROM  
	BW_TBL   BWTABLE, 
	BW_WB   WHITEBOARD,
	BW_NH   COLLAB_NH,
	BW_COLLAB   COLLAB,
	BW_TXS,
	BW_USER   BWUSER
WHERE 
	BWTABLE.ID = ?
	AND BWTABLE.BW_WB_ID = WHITEBOARD.ID
	AND COLLAB.ID = WHITEBOARD.BW_COLLAB_ID
	AND COLLAB_NH.ID = COLLAB.NEIGHBORHOOD_ID
	AND BWTABLE.LOCK_TX_ID = BW_TXS.TX_ID
	AND BW_TXS.CREATED_BY = BWUSER.ID