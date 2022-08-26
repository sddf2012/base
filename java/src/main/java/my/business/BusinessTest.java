package my.business;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author liu peng bo
 * @date 2022-7-29 15:27
 */
public class BusinessTest {
    public static void main(String[] args) {
        m1();
    }

    @Data
    static class Label {
        Integer id;
        String code;

        String detailType;

        public Label(Integer id, String code, String detailType) {
            this.id = id;
            this.code = code;
            this.detailType = detailType;
        }
    }

    public static void m1() {
        //查询label
        List<Label> labelWithClues = new ArrayList<>();
        //labelWithClues.add(new Label(1, "m123_p1", "1"));
        labelWithClues.add(new Label(1, "m456_p1", "2"));
        //labelWithClues.add(new Label(1,"m123_p2","1"));
        //labelWithClues.add(new Label(1,"m123_p2","1"));

        Set<String> productSet = new HashSet<>();
        //key:产品;value:模型
        Map<String, String> productRecommendLabel = new HashMap<>();
        Map<String, String> purchasePotentialLabel = new HashMap<>();
        labelWithClues.forEach(label -> {
            String labelCode = label.getCode();
            String[] labelCodes = labelCode.split("_");

            String module = labelCodes[0];
            String product = labelCodes[1];
            productSet.add(product);
            if ("1".equals(label.getDetailType())) {
                productRecommendLabel.put(product, module);
            }
            if ("2".equals(label.getDetailType())) {
                purchasePotentialLabel.put(product, module);
            }
        });

        StringBuilder itemId = new StringBuilder();
        StringBuilder productsRecommended = new StringBuilder();
        StringBuilder purchasePotential = new StringBuilder();

        productSet.forEach(product -> {
            itemId.append(product).append(",");

            String currentProductsRecommended = "";
            String currentPurchasePotential = "";
            if (productRecommendLabel.get(product) == null) {
                currentProductsRecommended = "%s";
            } else {
                currentProductsRecommended = productRecommendLabel.get(product) + "_%s";
            }
            if (purchasePotentialLabel.get(product) == null) {
                currentPurchasePotential = "%s";
            } else {
                currentPurchasePotential = purchasePotentialLabel.get(product) + "_%s";
            }
            productsRecommended.append(currentProductsRecommended).append(",");
            purchasePotential.append(currentPurchasePotential).append(",");
        });

        String productsRecommendedStr = productsRecommended.substring(0, productsRecommended.lastIndexOf(","));
        String purchasePotentialStr = purchasePotential.substring(0, purchasePotential.lastIndexOf(","));

        /*result = new ArrayList<>();
        int itemSize = productSet.size();
        List<String> productList = new ArrayList<>(productSet);
        for (JSONObject jsonObject : jsonObjects) {
            ActvModuleCustEntity entity = jsonObject.toJavaObject(ActvModuleCustEntity.class);
            entity.setPredictItemId(itemId.toString());
            Object[] scores = new String[itemSize];
            Object[] reals = new String[itemSize];
            for (int i = 0; i < itemSize; i++) {
                String product = productList.get(i);
                scores[i] = productRecommendLabel.get(product) == null ? "" : jsonObject.getString(productRecommendLabel.get(product) + "_" + product);
                reals[i] = purchasePotentialLabel.get(product) == null ? "" : jsonObject.getString(purchasePotentialLabel.get(product) + "_" + product);
            }
            entity.setWeightedScore(String.format(productsRecommendedStr, scores));
            entity.setPredictReal(String.format(purchasePotentialStr, reals));
            result.add(entity);
        }*/
        System.out.println(itemId.toString());
        System.out.println(productsRecommendedStr);
        System.out.println(purchasePotentialStr);

    }
}
