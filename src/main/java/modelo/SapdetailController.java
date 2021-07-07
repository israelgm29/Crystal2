package modelo;

import entidades.Sapdetail;
import modelo.util.JsfUtil;
import modelo.util.PaginationHelper;
import beans.SapdetailFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("sapdetailController")
@SessionScoped
public class SapdetailController implements Serializable {

    private Sapdetail current;
    private DataModel items = null;
    @EJB
    private beans.SapdetailFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public SapdetailController() {
    }

    public Sapdetail getSelected() {
        if (current == null) {
            current = new Sapdetail();
            current.setSapdetailPK(new entidades.SapdetailPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private SapdetailFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Sapdetail) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Sapdetail();
        current.setSapdetailPK(new entidades.SapdetailPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getSapdetailPK().setInvoiceid(current.getInvoice().getId());
            current.getSapdetailPK().setUptakeid(current.getUptake().getId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SapdetailCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Sapdetail) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getSapdetailPK().setInvoiceid(current.getInvoice().getId());
            current.getSapdetailPK().setUptakeid(current.getUptake().getId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SapdetailUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Sapdetail) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SapdetailDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Sapdetail getSapdetail(entidades.SapdetailPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Sapdetail.class)
    public static class SapdetailControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SapdetailController controller = (SapdetailController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sapdetailController");
            return controller.getSapdetail(getKey(value));
        }

        entidades.SapdetailPK getKey(String value) {
            entidades.SapdetailPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.SapdetailPK();
            key.setId(Integer.parseInt(values[0]));
            key.setInvoiceid(Integer.parseInt(values[1]));
            key.setUptakeid(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(entidades.SapdetailPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getId());
            sb.append(SEPARATOR);
            sb.append(value.getInvoiceid());
            sb.append(SEPARATOR);
            sb.append(value.getUptakeid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Sapdetail) {
                Sapdetail o = (Sapdetail) object;
                return getStringKey(o.getSapdetailPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Sapdetail.class.getName());
            }
        }

    }

}
