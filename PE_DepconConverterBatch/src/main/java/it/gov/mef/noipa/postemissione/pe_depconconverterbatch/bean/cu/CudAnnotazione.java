package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldOptional;
import org.coury.jfilehelpers.annotations.FieldTrim;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.FixedMode;
import org.coury.jfilehelpers.enums.TrimMode;

@FixedLengthRecord(fixedMode=FixedMode.AllowLessChars)
public class CudAnnotazione {
	
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio1;

	@FieldFixedLength(3)
	public String ano;

	@FieldFixedLength(110)
	@FieldOptional
	public String note;
}
