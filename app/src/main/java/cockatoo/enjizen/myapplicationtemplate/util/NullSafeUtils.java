package cockatoo.enjizen.myapplicationtemplate.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class NullSafeUtils {


	private static NullSafeUtils instance;

	public static NullSafeUtils getInstance(){
		if(instance == null){
			instance = new NullSafeUtils();
		}

		return instance;
	}

	private NullSafeUtils(){}

	public boolean isEmpty(String st){
		boolean b = true;
		if(st!=null && st.trim().length()>0){
			b = false;
		}
		return (b);

	}

	public boolean isEmpty(StringBuilder st){
		boolean b = true;
		if(st!=null && st.toString().trim().length()>0){
			b = false;
		}
		return (b);

	}

	public boolean isEmpty(List<?> ls ){
		boolean b = true;
		if(ls!=null && !ls.isEmpty()){
			b = false;
		}
		return (b);

	}

	public boolean isEmpty(Map<?, ?> map){
		boolean b = true;
		if(map!=null && !map.isEmpty()){
			b = false;
		}
		return(b);
	}

	public boolean isEmpty(Integer integer){
		return (isNull(integer));

	}

	public boolean isEmpty(Byte byt){
		return (isNull(byt));

	}

	public boolean isEmpty(Short s){
		return (isNull(s));

	}

	public boolean isEmpty(Long l){
		return (isNull(l));

	}

	public boolean isEmpty(Character c){
		return (isNull(c));

	}

	public boolean isEmpty(Float f){
		return (isNull(f));

	}

	public boolean isEmpty(Double d){
		return (isNull(d));

	}

	public boolean isEmpty(Number num){
		return (isNull(num));

	}

	public boolean isEmpty(BigDecimal d){
		return (isNull(d));

	}

	public boolean isNull(Object obj){
		boolean b = true;
		if(obj != null){
			b = false;
		}
		return (b);
	}

	public Object getDefaultValueIfNull(Object value, Object defaultValue){
		Object result = defaultValue;
		if(value != null){
			result = value;
		}
		return(result);
	}

	public boolean isNotEmpty(String st){
		boolean b = true;
		if(st ==null || st.trim().length()==0){
			b = false;
		}
		return (b);

	}

	public boolean isNotEmpty(List<?> ls ){
		boolean b = false;
		if(ls!=null && !ls.isEmpty()){
			b = true;
		}
		return (b);

	}

	public boolean isNotEmpty(Map<?,?> map){
		boolean b = false;
		if(map!=null && !map.isEmpty()){
			b = true;
		}
		return(b);
	}

	public boolean isNotEmpty(Integer integer){
		return (isNotNull(integer));

	}

	public boolean isNotEmpty(Byte byt){
		return (isNotNull(byt));

	}

	public boolean isNotEmpty(Short s){
		return (isNotNull(s));

	}

	public boolean isNotEmpty(Long l){
		return (isNotNull(l));

	}

	public boolean isNotEmpty(Character c){
		return (isNotNull(c));

	}

	public boolean isNotEmpty(Float f){
		return (isNotNull(f));

	}

	public boolean isNotEmpty(Double d){
		return (isNotNull(d));

	}

	public boolean isNotEmpty(Number num){
		return (isNotNull(num));

	}

	public boolean isNotEmpty(BigDecimal d){
		return (isNotNull(d));

	}

	public boolean isNotEmpty(Object obj){
		boolean b = false;
		if(obj != null){
			b = true;
		}
		return (b);
	}

	public boolean isNotNull(Object obj){
		boolean b = false;
		if(obj != null){
			b = true;
		}
		return (b);
	}


	public boolean isNotBlank(CharSequence cs) {
		return !isBlank(cs);
	}


	public boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs != null && (strLen = cs.length()) != 0) {
			for(int i = 0; i < strLen; ++i) {
				if (!Character.isWhitespace(cs.charAt(i))) {
					return false;
				}
			}

			return true;
		} else {
			return true;
		}
	}
	
}
