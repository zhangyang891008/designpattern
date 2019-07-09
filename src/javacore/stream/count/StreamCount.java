package javacore.stream.count;
 
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

 
public class StreamCount {
	public static URL getFile(String file) {
		URL resource = StreamCount.class.getClassLoader().getResource(file);
		return resource;
	}
	public static void main(String[] args) throws IOException, URISyntaxException {
		URL file = getFile("files/abc.txt");
		byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
		String Context = new java.lang.String(bytes, StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(Context.split("\\PL+"));
		//1.
		long count = words.stream().filter(w->w.length()>5).count();
		System.out.println(count);
		//2
		words.stream().filter(w->w.length()>5).forEach(System.out::println);
		//3
		words.parallelStream().filter(w->w.length()>5).forEach(System.out::println);
		//4生产随机数的无限流，可以用来生成一定数量的随机数
		Stream<Double> randoms = Stream.generate(Math::random);
		randoms.limit(10).forEach(System.out::println);
		//5无限流
		Stream<String> echos = Stream.generate(()->"echo");
		echos.limit(20).forEach(System.out::println);
		//6第一个参数是种子，第二个是f(seed),第三个是f(f(seed))
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n->n.add(BigInteger.ONE));
		integers.limit(10).forEach(System.out::println);
		//7
		URL linesFile= getFile("files/lines.txt");
		Path path = Paths.get(linesFile.toURI());
		Stream<String> linesStream = Files.lines(path);
		linesStream.forEach(System.out::println);
	}

}
