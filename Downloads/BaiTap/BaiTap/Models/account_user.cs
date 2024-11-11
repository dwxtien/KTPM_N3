namespace BaiTap.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class account_user
    {
        [Key]
        [Column(Order = 0)]
        [StringLength(30)]
        public string username { get; set; }

        [Key]
        [Column(Order = 1)]
        [StringLength(50)]

        public string password { get; set; }

        [StringLength(30)]
        [DisplayName("UserName")]
        [Required(ErrorMessage ="enter the password")]
        public string fullName { get; set; }
        [NotMapped]
        public bool RememberMe { get; set; }
        public DateTime? dateofbirth { get; set; }
    }
}
