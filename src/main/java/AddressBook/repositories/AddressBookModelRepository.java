package AddressBook.repositories;

import AddressBook.models.AddressBookModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbooks", path = "addressbooks")
public interface AddressBookModelRepository extends PagingAndSortingRepository<AddressBookModel, Long> {
    AddressBookModel findById(long id);
}
