package org.vaadin.test;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.ui.Grid;

public class GeneratedPropertyGrid extends Grid {
    private static final long serialVersionUID = 4442703450395364728L;

    public GeneratedPropertyGrid() {

        // Bean item container serves as the base container
        BeanItemContainer<DemoBean> container = new BeanItemContainer<>(DemoBean.class);

        // List of demo data
        List<DemoBean> demoBeans = getBeans();
        container.addAll(demoBeans);

        // Generated property container wrapper for base container
        GeneratedPropertyContainer generatedPropertyWrapper = new GeneratedPropertyContainer(container);
        // adding first generated property to wrapper, id of property is 'age + 10'
        generatedPropertyWrapper.addGeneratedProperty("age + 10", new PropertyValueGenerator<String>() {
            private static final long serialVersionUID = -7063445914770769439L;

            @Override
            public String getValue(Item item, Object itemId, Object propertyId) {
                // cell in generated column gets value (age + 10) for each Bean
                return "" + (((DemoBean) itemId).age + 10);
            }

            @Override
            public Class<String> getType() {
                return String.class;
            }
        });
        // adding second generated property to wrapper, id of property is 'name and age'
        generatedPropertyWrapper.addGeneratedProperty("name and age", new PropertyValueGenerator<String>() {
            @Override
            public String getValue(Item item, Object itemId, Object propertyId) {
                // cell in generated column gets a concatenated value
                DemoBean rowBean = (DemoBean) itemId;
                return "Name: " + rowBean.getName() + ", age: " + rowBean.getAge();
            }

            @Override
            public Class<String> getType() {
                return String.class;
            }
        });
        // Grid gets the wrapper Container
        setContainerDataSource(generatedPropertyWrapper);
    }

    // demo data generator method
    private List<DemoBean> getBeans() {
        List<DemoBean> demoBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoBean b = new DemoBean();
            b.setName("DemoBean " + i);
            b.setAge(i);
            demoBeans.add(b);
        }
        return demoBeans;
    }

    // demo data structure
    public static class DemoBean {
        private String name;

        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
