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
		boolean b = isNull(integer);
		return (b);

	}

	public boolean isEmpty(Byte byt){
		boolean b = isNull(byt);
		return (b);

	}

	public boolean isEmpty(Short s){
		boolean b = isNull(s);
		return (b);

	}

	public boolean isEmpty(Long l){
		boolean b = isNull(l);
		return (b);

	}

	public boolean isEmpty(Character c){
		boolean b = isNull(c);
		return (b);

	}

	public boolean isEmpty(Float f){
		boolean b = isNull(f);
		return (b);

	}

	public boolean isEmpty(Double d){
		boolean b = isNull(d);
		return (b);

	}

	public boolean isEmpty(Number num){
		boolean b = isNull(num);
		return (b);

	}

	public boolean isEmpty(BigDecimal d){
		boolean b = isNull(d);
		return (b);

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
		boolean b = isNotNull(integer);
		return (b);

	}

	public boolean isNotEmpty(Byte byt){
		boolean b = isNotNull(byt);
		return (b);

	}

	public boolean isNotEmpty(Short s){
		boolean b = isNotNull(s);
		return (b);

	}

	public boolean isNotEmpty(Long l){
		boolean b = isNotNull(l);
		return (b);

	}

	public boolean isNotEmpty(Character c){
		boolean b = isNotNull(c);
		return (b);

	}

	public boolean isNotEmpty(Float f){
		boolean b = isNotNull(f);
		return (b);

	}

	public boolean isNotEmpty(Double d){
		boolean b = isNotNull(d);
		return (b);

	}

	public boolean isNotEmpty(Number num){
		boolean b = isNotNull(num);
		return (b);

	}

	public boolean isNotEmpty(BigDecimal d){
		boolean b = isNotNull(d);
		return (b);

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
