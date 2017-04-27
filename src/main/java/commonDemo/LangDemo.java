package commonDemo;


import org.apache.commons.lang3.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * demo for lang
 */
public class LangDemo {

	public void charSetDemo() {
		System.out.println("***Char set demo***");
		CharSet charSet = CharSet.getInstance("aeiou");

		String demoStr = "The quick brown fox jumps over the lazy dog.";
		int count = 0;
		for(int i = 0; i < demoStr.length(); i++){
			if(charSet.contains(demoStr.charAt(i))){
				count++;
			}
		}
		System.out.println("count = " + count);
	}

	public void charSetUtilsDemo() {
		System.out.println("=====Char Set Utilities Demo");
		System.out.println("计算字符串中包含某字符个数");
		System.out.println(CharSetUtils.count("The quick brown fox jumps over the lazy dog.", "aeiou"));

		System.out.println(CharSetUtils.delete("the quick brown fox jumos over the lazy dog.", "aeiou"));

		System.out.println(CharSetUtils.keep("abcdefghijklmnopqrstuvwxyz.", "a-f"));


		System.out.println(CharSetUtils.squeeze("a  bbbbbb     c dd", "b d"));

	}

	public void objectUtilsDemo() {
		System.out.println("**ObjectUtilsDemo**");
		System.out.println("Object为null时，默认打印某字符.");
		Object obj = null;
		System.out.println(ObjectUtils.defaultIfNull(obj, "空"));

		System.out.println("验证两个引用是否指向的Object是否相等,取决于Object的equals()方法.");
		Object a = new Object();
		Object b = a;
		Object c = new Object();
		System.out.println(ObjectUtils.equals(a, b));
		System.out.println(ObjectUtils.equals(a, c));

		System.out.println("用父类Object的toString()方法返回对象信息.");
		Date date = new Date();
		System.out.println(ObjectUtils.identityToString(date));
		System.out.println(date);

		System.out.println("返回类本身的toString()方法结果,对象为null时，返回0长度字符串.");
		System.out.println(ObjectUtils.toString(date));
		System.out.println(ObjectUtils.toString(null));
		System.out.println(date);

	}

	public void randomStringUtils() {
		System.out.println(RandomStringUtils.randomAlphanumeric(5));
		System.out.println(RandomStringUtils.randomNumeric(5));
		System.out.println(RandomStringUtils.randomAlphabetic(5));
		RandomStringUtils randomStringUtils = new RandomStringUtils();

	}

	public void stringTool() {
		String str = "abcdefghijklmnopqrstuvwxyz.";
		System.out.println(StringUtils.abbreviate(str,6));
		System.out.println(StringUtils.abbreviate(str, 2, 5));

		String[] header = new String[3];
		header[0] = StringUtils.repeat("*", 50);
		header[1] = StringUtils.center("  StringUtilsDemo  ", 50, "^O^");
		header[2] = header[0];
		String head = StringUtils.join(header, "\n");
		System.out.println(head);

		System.out.println(StringUtils.indexOfDifference("aaabc", "aaacc"));

		System.out.println(StringUtils.difference("aaabcde", "aaaccde"));

		System.out.println(StringUtils.chomp("aaabcde"));
	}

	private String genHeader(String head)
	{
		String[] header = new String[3];
		header[0] = StringUtils.repeat("*", 50);
		header[1] = StringUtils.center("  " + head + "  ", 50, "^O^");
		header[2] = header[0];
		return StringUtils.join(header, "\n");
	}

	public void classUtilsDemo(){
		System.out.println(genHeader("ClassUtilsDemo"));
		System.out.println("获取类实现的所有接口.");
		System.out.println(ClassUtils.getAllInterfaces(Date.class));

		System.out.println("获取类所有父类.");
		System.out.println(ClassUtils.getAllSuperclasses(Date.class));

		System.out.println("获取简单类名.");
		System.out.println(ClassUtils.getShortClassName(Date.class));

		System.out.println("获取包名.");
		System.out.println(ClassUtils.getPackageName(Date.class));

		System.out.println("判断是否可以转型.");
		System.out.println(ClassUtils.isAssignable(Date.class, Object.class));
		System.out.println(ClassUtils.isAssignable(Object.class, Date.class));
	}

	private final class BuildDemo {
		String name;
		int age;

		public BuildDemo(String name, int age)
		{
			this.name = name;
			this.age = age;
		}

		public String toString() {
			ToStringBuilder tsb  = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
			tsb.append("Name", name);
			tsb.append("Age", age);
			return tsb.toString();
		}

		public int hashCode()
		{
			HashCodeBuilder hcb = new HashCodeBuilder();
			hcb.append(name);
			hcb.append(age);
			return hcb.hashCode();
		}

		public boolean equals(Object obj)
		{
			if (!(obj instanceof BuildDemo))
			{
				return false;
			}
			BuildDemo bd = (BuildDemo) obj;
			EqualsBuilder eb = new EqualsBuilder();
			eb.append(name, bd.name);
			eb.append(age, bd.age);
			return eb.isEquals();
		}
	}

	public void builderDemo()
	{
		System.out.println(genHeader("BuilderDemo"));
		BuildDemo obj1 = new BuildDemo("a", 1);
		BuildDemo obj2 = new BuildDemo("b", 2);
		BuildDemo obj3 = new BuildDemo("a", 1);

		System.out.println("toString()");
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);

		System.out.println("hashCode()");
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());

		System.out.println("equals()");
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
	}

	public static void main(String[] args) {
		LangDemo langDemo = new LangDemo();
//		langDemo.charSetDemo();
//
//		CharSet instance1 = CharSet.getInstance("^a-c");
//		System.out.println(instance1);
//
//		CharSet charSet = CharSet.getInstance("aeiou");
//		System.out.println(charSet.toString());
		//langDemo.charSetUtilsDemo();
		langDemo.builderDemo();

	}

}
