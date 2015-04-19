package org.vaadin.tunis.blood_donation.samples.crud;

import org.vaadin.tunis.blood_donation.entities.BloodType;
import org.vaadin.tunis.blood_donation.entities.Gender;
import org.vaadin.tunis.blood_donation.samples.backend.DataService;
import org.vaadin.tunis.blood_donation.samples.backend.data.Product;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitEvent;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

/**
 * A form for editing a single product.
 * 
 * Using responsive layouts, the form can be displayed either sliding out on the
 * side of the view or filling the whole screen - see the theme for the related
 * CSS rules.
 */
public class ProductForm extends UserFormDesign {

	private SampleCrudLogic viewLogic;
	private BeanFieldGroup<Product> fieldGroup;
	private final static String MALE = "Male";
	private final static String FEMALE = "Female";

	public ProductForm(SampleCrudLogic sampleCrudLogic) {
		super();
		addStyleName("product-form");
		viewLogic = sampleCrudLogic;

		for (BloodType s : BloodType.values()) {
			bloodType.addItem(s.getBloodType());
		}

		gender.addItem(MALE);
		gender.setItemIcon(MALE, FontAwesome.MALE);
		gender.addItem(FEMALE);
		gender.setItemIcon(FEMALE, FontAwesome.FEMALE);

		fieldGroup = new BeanFieldGroup<Product>(Product.class);
		fieldGroup.bindMemberFields(this);

		// perform validation and enable/disable buttons while editing
		ValueChangeListener valueListener = new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				formHasChanged();
			}
		};
		for (Field f : fieldGroup.getFields()) {
			f.addValueChangeListener(valueListener);
		}

		fieldGroup.addCommitHandler(new CommitHandler() {

			@Override
			public void preCommit(CommitEvent commitEvent)
					throws CommitException {
			}

			@Override
			public void postCommit(CommitEvent commitEvent)
					throws CommitException {
				DataService.get().updateProduct(
						fieldGroup.getItemDataSource().getBean());
			}
		});

		save.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					fieldGroup.commit();

					// only if validation succeeds
					Product product = fieldGroup.getItemDataSource().getBean();
					viewLogic.saveProduct(product);
				} catch (CommitException e) {
					Notification n = new Notification(
							"Please re-check the fields", Type.ERROR_MESSAGE);
					n.setDelayMsec(500);
					n.show(getUI().getPage());
				}
			}
		});

		cancel.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				viewLogic.cancelProduct();
			}
		});

		delete.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Product product = fieldGroup.getItemDataSource().getBean();
				viewLogic.deleteProduct(product);
			}
		});
	}

	// public void setCategories(Collection<Category> categories) {
	// category.setOptions(categories);
	// }

	public void editProduct(Product product) {
		if (product == null) {
			product = new Product();
		}
		fieldGroup.setItemDataSource(new BeanItem<Product>(product));

		// before the user makes any changes, disable validation error indicator
		// of the product name field (which may be empty)
		fullName.setValidationVisible(false);

		// Scroll to the top
		// As this is not a Panel, using JavaScript
		String scrollScript = "window.document.getElementById('" + getId()
				+ "').scrollTop = 0;";
		Page.getCurrent().getJavaScript().execute(scrollScript);
	}

	private void formHasChanged() {
		// show validation errors after the user has changed something
		fullName.setValidationVisible(true);

		// only products that have been saved should be removable
		boolean canRemoveProduct = false;
		BeanItem<Product> item = fieldGroup.getItemDataSource();
		if (item != null) {
			Product product = item.getBean();
			canRemoveProduct = product.getId() != -1;
		}
		delete.setEnabled(canRemoveProduct);
	}
}
