function convertEscapeChar(strPrint) {
	strPrint = String(strPrint).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;'); 

	return strPrint;
}