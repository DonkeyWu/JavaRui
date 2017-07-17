package com.yt.tools.check;

public class YtAssert {

	/**
	 * Assert that an object is not {@code null} .
	 * <pre class="code">Assert.notNull(clazz);</pre>
	 * @param object the object to check
	 * @throws IllegalArgumentException if the object is {@code null}
	 */
	public static void notNull(Object object, Class<?> cls , String message) {
		notNull(object , cls.getName() , message);
	}
	
	public static void notNull(Object object, Object target , String message){
		if (object == null) {
			throw new IllegalArgumentException("["+target.toString()+"] -- [ "+message+" ]");
		}
	}
	
	/**
	 * Assert that an object is not {@code null} .
	 * <pre class="code">Assert.notNull(clazz);</pre>
	 * @param object the object to check
	 * @throws IllegalArgumentException if the object is {@code null}
	 */
	public static void notNull(Object object) {
		notNull(object, "YtAssert"," [Assertion failed] - this argument is required; it must not be null");
	}
	
}
