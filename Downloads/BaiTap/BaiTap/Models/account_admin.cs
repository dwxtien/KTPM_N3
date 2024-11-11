namespace BaiTap.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class account_admin
    {
        [Key]
        [Column(Order = 0)]
        [StringLength(30)]
        public string adminName { get; set; }

        [Key]
        [Column(Order = 1)]
        [StringLength(30)]
        public string password { get; set; }
    }
}
