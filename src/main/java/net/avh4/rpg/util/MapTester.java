package net.avh4.rpg.util;

import com.google.common.collect.Lists;
import net.avh4.rpg.model.maps.MapSpecification;
import net.avh4.rpg.primitives.Map;
import net.avh4.rpg.primitives.tilesets.Tileset;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.ServiceLoader;

public class MapTester extends JComponent implements ListSelectionListener, ActionListener {

    private final MapTesterView view;
    private static final ServiceLoader<Tileset> tilesetLoader = ServiceLoader.load(Tileset.class);
    private static final ServiceLoader<MapList> mapLoader = ServiceLoader.load(MapList.class);


    public static void main(String[] args) {
        JFrame window = new JFrame("Map Tester");
        window.add(new MapTester().view.root);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
    }

    public MapTester() {
        view = new MapTesterView();

        MapSpecification[] specs = createMapSpecs();
        ArrayList<Tileset> tilesets = Lists.newArrayList(tilesetLoader);
        ArrayList<Class<? extends Map>> mapClasses = new ArrayList<Class<? extends Map>>();
        for (MapList mapList : mapLoader) {
            mapClasses.addAll(mapList.get());
        }

        configureList(view.mapSpecificationList, specs);
        configureList(view.tilesetList, tilesets.toArray());
        configureList(view.mapGeneratorList, mapClasses.toArray());

        view.regenerateMapButton.addActionListener(this);

        showMap();
    }

    @SuppressWarnings("ChainedMethodCall")
    private static MapSpecification[] createMapSpecs() {
        return new MapSpecification[]{
                new MapSpecification().exitsTo("weapon shop", "armor shop", "inn"),
                new MapSpecification().exitsTo("outland", "boss"),
                new MapSpecification().exitsTo("Tantagel", "Brecconary", "Erdrick's Cave", "Garinham",
                        "Kol", "Northern Cellar", "Swamp Cave",
                        "Swamp Cave South", "Rimuldar", "Southern Cellar",
                        "Cantlin", "Hauksness", "Southern Cellar",
                        "Charlock Castle", "Golem", "Erdrick's Token",
                        "Rainbow Bridge", "Rock Mountain Cave"),
        };
    }

    private void configureList(JList list, Object[] items) {
        list.setListData(items);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
    }

    private void showMap() {
        Tileset tileset = getTileset();
        MapSpecification spec = getMapSpec();
        try {
            Map m = getMap(spec, tileset);
            view.mapView.setMap(m);
            view.tabs.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String stacktrace = sw.toString();
            view.errorMessage.setText(stacktrace);
            view.errorMessage.setSelectionStart(0);
            view.errorMessage.setSelectionEnd(0);
            view.tabs.setSelectedIndex(1);
        }
    }

    private Map getMap(MapSpecification spec, Tileset tileset) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class mapClass = (Class) view.mapGeneratorList.getSelectedValue();
        Constructor ctor = mapClass.getConstructor(MapSpecification.class, Tileset.class);
        try {
            return (Map) ctor.newInstance(spec, tileset);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof RuntimeException) {
                throw (RuntimeException) e.getCause();
            } else {
                throw e;
            }
        }
    }

    private MapSpecification getMapSpec() {
        return (MapSpecification) view.mapSpecificationList.getSelectedValue();
    }

    private Tileset getTileset() {
        return (Tileset) view.tilesetList.getSelectedValue();
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        showMap();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        showMap();
    }
}
