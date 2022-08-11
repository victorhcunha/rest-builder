import java.util.ArrayList;

import com.acme.headless.r3b2.client.dto.v1_0.Foo;
import com.acme.headless.r3b2.client.resource.v1_0.FooResource;

import com.acme.headless.r3b2.client.dto.v1_0.Goo;
import com.acme.headless.r3b2.client.resource.v1_0.GooResource;

public class Test {

	public static void main(String[] args) throws Exception {
		FooResource.Builder builder = FooResource.builder();

		FooResource fooResource = builder.authentication(
				"test@liferay.com", "test").build();

		{
			ArrayList<Foo> listFoo = new ArrayList<Foo>();

			Foo foo1 = fooResource.getFoo(1L);
			listFoo.add(foo1);

			Foo foo2 = fooResource.getFoo(2L);
			listFoo.add(foo2);

			Foo foo3 = fooResource.getFoo(3L);
			listFoo.add(foo3);

			for (Foo fooElement : listFoo) {
				System.out.println(fooElement);
			}
		}

		GooResource.Builder builderG = GooResource.builder();
		GooResource gooResource = builderG.authentication(
				"test@liferay.com", "test").build();

		{
			ArrayList<Goo> listGoo = new ArrayList<Goo>();

			Goo goo1 = gooResource.getGoo(1L);
			listGoo.add(goo1);

			Goo goo2 = gooResource.getGoo(2L);
			listGoo.add(goo2);

			Goo goo3 = gooResource.getGoo(3L);
			listGoo.add(goo3);

			Goo goo4 = gooResource.getGoo(4L);
			listGoo.add(goo4);

			Goo goo5 = gooResource.getGoo(5L);
			listGoo.add(goo5);

			Goo goo6 = gooResource.getGoo(6L);
			listGoo.add(goo6);

			for (Goo gooElement : listGoo) {
				System.out.println(gooElement);
			}
		}
	}

}